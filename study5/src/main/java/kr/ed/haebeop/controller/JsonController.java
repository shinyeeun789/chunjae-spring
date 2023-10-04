package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// @Controller 대신 @RestController 사용 시 @ResponseBody 어노테이션을 작성해주지 않아도 됨
@Controller
@RequestMapping("/json/*")
public class JsonController {

    @Autowired
    private TestService testService3;

    // @ResponseBody 어노테이션 사용 시 TestVO 객체가 JSON 형태로 변경됨
    @GetMapping("getTest/{num}")
    @ResponseBody
    public TestVO viewTest(@PathVariable int num) throws Exception {
        TestVO test = testService3.getTest(num);
        return test;
    }

    @GetMapping("insertForm")
    public String insertForm(Model model) throws Exception {
        return "/test/testInsert";
    }

    // RequestBody => View로부터 데이터를 JSON 형태로 받아오겠다는 의미
    // ResponseBody => JSON 형태로 View에게 리턴하겠다는 의미
    @PostMapping("insertForm")
    @ResponseBody
    public TestVO insertPro(@ModelAttribute TestVO test) throws Exception {     // JAVA 일반 객체로 받는 경우
        testService3.testInsert(test);
        return test;
    }

    @GetMapping("insertForm2")
    public String insertForm2(Model model) throws Exception {
        return "/test/testInsert2";
    }

    @PostMapping("insertForm2")
    @ResponseBody
    public TestVO insertPro2(@RequestBody TestVO test) throws Exception {       // JSON 객체로 받는 경우
        testService3.testInsert(test);
        return test;
    }

}
