package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.User;
import kr.ed.haebeop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Inject
    BCryptPasswordEncoder pwdEncoder;

    @Autowired
    HttpSession session;

    // 회원 목록 보기
    @RequestMapping(value="list", method=RequestMethod.GET)
    public String userList(Model model) throws Exception {
        List<User> userList = userService.userList();
        model.addAttribute("userList", userList);
        return "/admin/userList";
    }

    @RequestMapping(value="getUser", method=RequestMethod.GET)
    public String getUser(@RequestParam String id, Model model) throws Exception {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "/user/myInfo";
    }

    @RequestMapping(value="insertForm", method=RequestMethod.GET)
    public String insertForm(Model model) throws Exception {
        return "/user/userInsert";
    }

    @RequestMapping(value="userInsert", method=RequestMethod.POST)
    public String userInsert(User user, Model model) throws Exception {
        userService.userInsert(user);
        return "redirect:/";
    }

    @RequestMapping(value="loginForm", method=RequestMethod.GET)
    public String loginForm(Model model) throws Exception {
        return "/user/login";
    }

    @RequestMapping(value="loginCheck", method=RequestMethod.POST)
    public void loginCheck(User user, Model model) throws Exception {

    }

    @RequestMapping(value="userUpdate", method=RequestMethod.GET)
    public String userUpdate(Model model) throws Exception {
        String id = (String) session.getAttribute("sid");
        User user = userService.getUser(id);
        model.addAttribute("user");
        return "/user/userUpdate";
    }

    @PostMapping("userUpdate")
    public void userUpdatePro(Model model) throws Exception {

    }


}
