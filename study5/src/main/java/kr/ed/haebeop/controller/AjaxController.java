package kr.ed.haebeop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @GetMapping("/")
    public String ajaxHome() {
        return "/ajax/home";
    }

    @GetMapping("/test1")
    public String ajaxTest1() {
        return "/ajax/test1";
    }

    @GetMapping("/test1pro")
    public String ajaxTest1Pro(@RequestParam("msg") String msg) {
        System.out.println(msg);
        return "/ajax/test1";
    }

    @GetMapping("/test2")
    public String ajaxTest2() {
        return "/ajax/test2";
    }

    @PostMapping("/test2pro")
    public String ajaxTest2Pro(@RequestParam("msg") String msg) {
        System.out.println(msg);
        return "/ajax/test2";
    }

}
