package com.chicken.project.notice.controller;

import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import com.chicken.project.notice.model.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

    private final NoticeService noticeService;
    @Autowired
    public NoticeController(NoticeService noticeService){

        this.noticeService = noticeService;
    }

    @GetMapping("/list")
    public ModelAndView noticeList(ModelAndView mv){

        List<NoticeDTO> noticeList = noticeService.selectAllList();

        mv.addObject("noticeList", noticeList);
        mv.setViewName("notice/notice_list");

        return mv;
    }

    @GetMapping("/insert")
    public String noticeInsertPage(){

        return "notice/notice_insert";
    }

    @PostMapping("/notice/insert")
    public String noticeInsert(@ModelAttribute NoticeDTO notice,
                               @RequestParam(value="file", required=false) MultipartFile file
                               ) throws Exception{

        NoticeFileDTO noticeFile = new NoticeFileDTO();

        System.out.println(notice);
        System.out.println(file);

        String root = ResourceUtils.getURL("src/main/resources").getPath();

        String filePath = root + "static/uploadFiles";

        System.out.println("루트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + filePath);

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

            noticeFile.setOriginName(originFileName);
            noticeFile.setFileName(changeName);

            int result = noticeService.noticeInsert(notice);

            if(result > 0) {

                int result2 = noticeService.noticeFileInsert(noticeFile);
            }

            try {
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e) {

                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }
        }

        System.out.println(originFileName + "/////////" + ext + "////////////" + changeName);

        return "redirect:/notice/list";
    }

    @GetMapping("/view")
    public ModelAndView noticeView(ModelAndView mv, @RequestParam int noticeNo){

        NoticeDTO noticeDetail = noticeService.noticeViewByNo(noticeNo);

        System.out.println(noticeDetail);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("notice/notice_view");

        return mv;
    }
}
