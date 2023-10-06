package kr.ed.haebeop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/* pom.xml에서 지정한 multipart 넣기 */
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/* webapp/lib/cos.jar 넣기 */
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FileUploadController {
    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    // fileupload 1~2는 개발 서버에 업로드
    // fileupload 3~4는 운영 서버에 업로드

    @GetMapping("/fileupload/fileUpload1")
    public String uploadForm1() {
        return "/fileupload/fileUpload1";
    }

    // 이미지 업로드처리 - com.orielly.servlet.MultipartRequest
    // 오래된 방식이라 제대로 동작하지 않음
    @PostMapping("/fileupload/fileUpload1")
    public String upload1(HttpServletRequest request, HttpServletResponse response) {
        String uploadPath = "d:/shin/spring/study6/src/main/webapp/resources/upload";
        int maxFileSize = 1024 * 1024 * 10;
        String encType = "utf-8";

        MultipartRequest multi = null;

        try {
            multi = new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
            log.info(multi.getOriginalFileName("upload"));
            log.info(multi.getFilesystemName("upload"));
        } catch (IOException e) {
            log.info("[에러] " + e.getMessage());
        }
        return "redirect:/";
    }

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
        log.info("files 매개변수 : " + files);
        if (files != null) {
            log.info("업로드한 첨부파일 개수 : " + files.size());
        }
        ServletContext application = request.getSession().getServletContext();      // 현재 프로젝트 디렉토리를 상대경로로
        String realPath = application.getRealPath("/resources/upload");
        log.info("realPath : " + realPath);
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
            log.info("업로드 파일 경로 및 이름 : " + uploadFilename);
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

    @GetMapping("/fileupload/fileUpload4")
    public String uploadForm4() {
        return "/fileupload/fileUpload4";
    }

    // ajax로 파일 업로드
    @ResponseBody
    @PostMapping("/fileupload/fileUpload4")
    public List<String> upload4(MultipartHttpServletRequest multipartRequest) throws IllegalStateException, IOException {
        List<MultipartFile> fileList = multipartRequest.getFiles("file");
        List<String> fileNames = new ArrayList<String>();
        ServletContext application = multipartRequest.getSession().getServletContext();
        String realPath = application.getRealPath("/resources/upload");
        log.info("realPath : " + realPath);
        File uploadPath = new File(realPath);
        for (MultipartFile multipartFile : fileList) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            String uploadFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
            fileNames.add(uploadFilename);
        }
        return fileNames;
    }

}
