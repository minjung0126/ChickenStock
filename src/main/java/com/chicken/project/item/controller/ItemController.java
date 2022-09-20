package com.chicken.project.item.controller;

import com.chicken.project.common.paging.Pagenation;
import com.chicken.project.common.paging.SelectCriteria;
import com.chicken.project.item.model.dto.ItemCategoryDTO;
import com.chicken.project.item.model.dto.ItemFileDTO;
import com.chicken.project.item.model.dto.ItemInfoDTO;
import com.chicken.project.item.model.service.ItemServiceImpl;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ItemServiceImpl itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemService){

        this.itemService = itemService;
    }

    @GetMapping("/admin/list")
    public ModelAndView itemList(HttpServletRequest request, ModelAndView mv){

        log.info("");
        log.info("");
        log.info("[itemController] =========================================================");
        
        /* 페이징 처리 & 전체 품목 리스트 조회 */

        String currentPage = request.getParameter("currentPage");
        int pageNo = 1;

        if(currentPage != null && !"".equals(currentPage)) {
            pageNo = Integer.parseInt(currentPage);
        }

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        log.info("[itemController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        int totalCount = itemService.selectTotalCount(searchMap);
        log.info("[itemController] totalBoardCount : " + totalCount);

        int limit = 10;
//        if(searchCondition != null && !"".equals(searchCondition)) {
//            limit = totalCount;
//        } else{
//            limit = 10;
//        }

        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[itemController] selectCriteria : " + selectCriteria);

        List<ItemInfoDTO> itemList = itemService.selectAllItem(selectCriteria);

        log.info("[itemController] itemList : " + itemList);

        /* 신규 등록 카테고리 옵션 조회 */

        List<ItemCategoryDTO> itemPreCategoryList = itemService.selectPreCategory();
        List<ItemCategoryDTO> itemCategoryList = itemService.selectCategory();

        mv.addObject("itemList", itemList);
            mv.addObject("selectCriteria", selectCriteria);
        log.info("[itemController] SelectCriteria : " + selectCriteria);

        mv.addObject("itemPreCategoryList", itemPreCategoryList);
        mv.addObject("itemCategoryList", itemCategoryList);

        mv.setViewName("item/admin/admin_item");

        return mv;
    }

    /* 상품 상세 조회 */
    @GetMapping(value = "itemDetail", produces = "application/json; charset = UTF-8")
    @ResponseBody
    public String getItemOne(HttpServletRequest request) {

        Gson gson  = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
                .setPrettyPrinting() 								// json 문자열 이쁘게 출력
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)  // 기본값
                .serializeNulls()									// 필드값이 null이어도 직렬화한다.
                .disableHtmlEscaping()								// 직렬화 시 escape 시퀀스 처리하지 않는다.
                .create();

        String itemNoInput = request.getParameter("itemNoInput");

        ItemInfoDTO item = itemService.selectOneItem(itemNoInput);


        return "";

    }


    @PostMapping("/admin/regist")
    public String itemRegist(@ModelAttribute ItemInfoDTO item, @RequestParam(value="file", required = false) MultipartFile file, RedirectAttributes rttr) throws Exception{

        System.out.println("테스트용 : " + item);
        ItemFileDTO itemFile = new ItemFileDTO();

        log.info("[itemController] ItemInfoDTO : " + item);
        log.info("[itemController] file : " + file);

        String root = ResourceUtils.getURL("src/main/resources").getPath();

        String filePath = root + "static/itemImage";

        log.info("루트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + filePath);

        File mkdir = new File(filePath);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }

        String originFileName = "";
        String ext = "";
        String changeName = "";

        if(file.getSize() > 0) {
            originFileName = file.getOriginalFilename();
            ext = originFileName.substring(originFileName.lastIndexOf("."));
            changeName = UUID.randomUUID().toString().replace("-",  "");


            itemFile.setOriginName(originFileName);
            itemFile.setFileName(changeName + ext);

            // 품목 등록
            int result = itemService.insertItem(item);


            // 품목 파일 등록
            if(result > 0) {
                itemService.insertItemHistory();
                itemService.insertFileRegist(itemFile);
            }

            try {
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e) {

                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }
        }



        rttr.addFlashAttribute("message", "상품 등록 성공");

        return "redirect:/item/admin/list";
    }

    @PostMapping("/admin/delete")
    public String itemDelete(@RequestParam(value="itemNoList", required = false) String itemNoList, RedirectAttributes rttr) throws Exception{

        System.out.println("itemNoList " + itemNoList);

        String[] itemNo = itemNoList.split(",");
        System.out.println(itemNo);

        for(int i = 0; i < itemNo.length; i++){
            itemService.deleteItemFile(itemNo[i]); // cascade로 바꾸고 지우기
            itemService.deleteItem(itemNo[i]);
        }

        rttr.addFlashAttribute("message", "상품 삭제 성공");

        return "redirect:/item/admin/list";
    }




}
