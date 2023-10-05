package kr.ed.haebeop.controller;

import kr.ed.haebeop.test.Check;
import kr.ed.haebeop.test.CheckVO;
import kr.ed.haebeop.test.CheckValidator;
import kr.ed.haebeop.test.CheckValidator2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/check/")
public class CheckController {
    @GetMapping("check1")   //http://localhost:8088/check/check1 GET
    public String check1(Model model) {
        return "/check/check1";
    }
    @PostMapping("check1") //http://localhost:8088/check/check1 POST
    public String check1Pro(@RequestParam String id, @RequestParam String pw, Model model){
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "/check/check1_result";
    }

    @GetMapping("check2")   //http://localhost:8088/check/check2 GET
    public String check2(Model model) {
        return "/check/check2";
    }

    @PostMapping("check2") //http://localhost:8088/check/check2 POST
    public String check2Pro(HttpServletRequest req, Model model){
        model.addAttribute("id", req.getParameter("id"));
        model.addAttribute("pw", req.getParameter("pw"));
        return "/check/check2_result";
    }

    @GetMapping("check3")   //http://localhost:8088/check/check3 GET
    public String check3(Model model) {
        return "/check/check3";
    }

    @GetMapping("check3pro") //http://localhost:8088/check/check3 POST
    public String check3Pro(HttpServletRequest req, Model model){
        model.addAttribute("id", req.getParameter("id"));
        model.addAttribute("pw", req.getParameter("pw"));
        return "/check/check3_result";
    }

    @GetMapping("check4")   //http://localhost:8088/check/check4 GET
    public String check4(Model model) {
        return "/check/check4";
    }

    @PostMapping("check4") //http://localhost:8088/check/check4 POST
    public String check4Pro(@ModelAttribute Check check, Model model, BindingResult result) {
        String page = "/check/check4_result";

        CheckValidator ckVal = new CheckValidator();
        ckVal.validate(check, result);
        if(result.hasErrors()) {
            page = "/check/error4";
        } else {
            model.addAttribute("check", check);
        }

        return page;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // CheckValidator가 검증도구라는 것을 미리 세팅해두는 것
        // 단, 하나의 컨트롤러에서는 여러 개의 validator를 사용할 수 없다는 단점이 있음

//        binder.setValidator(new CheckValidator());
        binder.setValidator(new CheckValidator2());
    }

    @GetMapping("check5")   //http://localhost:8088/check/check5 GET
    public String check5(Model model) {
        return "/check/check5";
    }

    @PostMapping("check5pro") //http://localhost:8088/check/check5 POST
    public String check5Pro(@ModelAttribute("check") @Valid Check check, Model model, BindingResult result) {
        String page = "/check/check5_result";
        if(result.hasErrors()) {
            page = "/check/error5";
        } else {
            model.addAttribute("check", check);
        }

        return page;
    }

    @GetMapping("check6")
    public String check6(@ModelAttribute("chk") CheckVO chk, Model model) {
        model.addAttribute("chk", chk);
        return "/check/check6";
    }

    @PostMapping("check6")
    public String check6Pro(@ModelAttribute("chk") @Valid CheckVO chk, BindingResult result, Model model){
        String page = "/check/check6";
        model.addAttribute("chk", chk);
        return page;
    }

}
