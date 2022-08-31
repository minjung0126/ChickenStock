package com.chicken.project.notice.controller;

import com.chicken.project.exception.notice.NoticeDeleteException;
import com.chicken.project.exception.notice.NoticeUpdateException;
import com.chicken.project.notice.model.dto.NoticeDTO;
import com.chicken.project.notice.model.dto.NoticeFileDTO;
import com.chicken.project.notice.model.service.NoticeService;
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

    @GetMapping("/admin/list")
    public ModelAndView noticeList(ModelAndView mv){

        List<NoticeDTO> noticeList = noticeService.selectAllList();

        mv.addObject("noticeList", noticeList);
        mv.setViewName("/notice/admin/adminNoticeList");

        return mv;
    }

    @GetMapping("/user/list")
    public ModelAndView userNoticeList(ModelAndView mv){

        List<NoticeDTO> noticeList = noticeService.selectAllList();

        mv.addObject("noticeList", noticeList);
        mv.setViewName("/notice/user/userNoticeList");

        return mv;
    }

    @GetMapping("/admin/insert")
    public String noticeInsertPage(){

        return "/notice/admin/adminNoticeInsert";
    }

    @PostMapping("/admin/noticeInsert")
    public String noticeInsert(@ModelAttribute NoticeDTO notice,
                               @RequestParam(value="file", required=false) MultipartFile file,
                               RedirectAttributes rttr
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

                noticeService.noticeFileInsert(noticeFile);
            }

            try {
                file.transferTo(new File(filePath + "\\" + changeName + ext));
            } catch (IOException e) {

                e.printStackTrace();
                new File(filePath + "\\" + changeName + ext).delete();
            }
        }

        rttr.addFlashAttribute("message", "공지사항 등록 성공!");

        System.out.println(originFileName + "/////////" + ext + "////////////" + changeName);

        return "redirect:/notice/admin/list";
    }

    @GetMapping("/admin/detail")
    public ModelAndView adminNoticeDetail(ModelAndView mv, @RequestParam int noticeNo){

        NoticeDTO noticeDetail = noticeService.noticeDetailByNo(noticeNo);

        System.out.println(noticeDetail);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("/notice/admin/adminNoticeDetail");

        return mv;
    }

    @GetMapping("/user/detail")
    public ModelAndView userNoticeDetail(ModelAndView mv, @RequestParam int noticeNo){

        NoticeDTO noticeDetail = noticeService.noticeDetailByNo(noticeNo);

        System.out.println(noticeDetail);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("/notice/user/userNoticeDetail");

        return mv;
    }

    @GetMapping("/admin/delete")
    public String deleteNotice(HttpServletRequest request, RedirectAttributes rttr) throws NoticeDeleteException {

        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

        int result = noticeService.deleteNotice(noticeNo);

        rttr.addFlashAttribute("message", "공지사항 삭제 성공!");

        return "redirect:/notice/admin/list";
    }

    @GetMapping("/admin/update")
    public ModelAndView updateNoticePage(HttpServletRequest request, ModelAndView mv) {

        int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

        NoticeDTO noticeDetail = noticeService.noticeDetailByNo(noticeNo);

        mv.addObject("noticeDetail", noticeDetail);
        mv.setViewName("/notice/admin/adminNoticeUpdate");

        return mv;
    }

    @PostMapping("/admin/update")
    public String updateNotice(@ModelAttribute NoticeDTO notice,
                               RedirectAttributes rttr) throws NoticeUpdateException {

        System.out.println("notice = " + notice);

        noticeService.updateNotice(notice);

        rttr.addFlashAttribute("message", "공지사항 수정에 성공하셨습니다!");

        return "redirect:/notice/admin/list";
    }
}
