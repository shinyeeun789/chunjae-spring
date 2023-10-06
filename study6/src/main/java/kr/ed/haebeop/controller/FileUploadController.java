package kr.ed.haebeop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping("/fileupload/fileUpload2")
    public String uploadForm2() { return "/fileupload/fileUpload2"; }

    // 이미지 업로드 처리 - org.springframework.web.multipart.MultipartHttpServletRequest를 이용하는 경우
    @PostMapping("/fileupload/fileUpload2")
    public String upload1(MultipartHttpServletRequest multipartRequest) throws ServletException, IOException {
        List<MultipartFile> fileList = multipartRequest.getFiles("file");
        String uploadPath = "d:/shin/spring/study6/src/main/webapp/resources/upload";               // 개발 서버에 업로드할 것이기 때문에 직접 경로 설정
        log.info("파일 개수 : " + fileList.size());
        for (MultipartFile multipartFile : fileList) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            String uploadFilename = multipartFile.getOriginalFilename();
            log.info("업로드 파일 경로 및 이름 : " + uploadFilename);
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
        }
        return "redirect:/";
    }

    @GetMapping("/fileupload/fileUpload3")
    public String uploadForm3() { return "/fileupload/fileUpload3"; }

    // 이미지 업로드 처리 - org.springframework.web.multipart.MultipartFile를 이용하는 경우
    @PostMapping("/fileupload/fileUpload3")
    public String upload3(HttpServletRequest request, RedirectAttributes rttr, List<MultipartFile> files) throws IOException {
        System.out.println("files 매개변수 : " + files);
        if (files != null) {
            System.out.println("업로드한 첨부파일 개수 : " + files.size());
        }
        ServletContext application = request.getSession().getServletContext();      // 현재 프로젝트 디렉토리를 상대경로로
        String realPath = application.getRealPath("/resources/upload");
        System.out.println("realPath : " + realPath);
        File uploadPath = new File(realPath, getDateFolder());                      // 운영 서버 디렉토리에 폴더 동적 생성
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();                                                    // 운영 서버 디렉토리 생성
        }
        for (MultipartFile multipartFile : files) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            String uploadFilename = multipartFile.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
            uploadFilename = uuid.toString() + "_" + uploadFilename;
            System.out.println("업로드 파일 경로 및 이름 : " + uploadFilename);
            multipartFile.transferTo(new File(uploadPath, uploadFilename));         // 운영 서버에 파일 업로드 수행
        }
        return "redirect:/";
    }

    private String getDateFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String str = sdf.format(date);
        return str;
    }

}
