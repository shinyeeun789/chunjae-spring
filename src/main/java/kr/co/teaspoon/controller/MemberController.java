package kr.co.teaspoon.controller;

import kr.co.teaspoon.dto.Member;
import kr.co.teaspoon.service.MemberService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    HttpSession session;

    BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

    /* 관리자가 볼 수 있는 회원 목록 */
    @RequestMapping(value="list.do", method=RequestMethod.GET)
    public String memberList(Model model) throws Exception {
        List<Member> memberList = memberService.memberList();
        model.addAttribute("memberList", memberList);
        model.addAttribute("title", "회원 목록");
        return "/member/memberList";
    }

    /* 관리자가 회원의 상세 정보 보기 */
    @GetMapping("detail.do")
    public String detail(@RequestParam String id, Model model) throws Exception {
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "/member/memberDetail";
    }

    @GetMapping("delete.do")
    public String memberDelete(HttpServletRequest request, Model model) throws Exception {
        String id = request.getParameter("id");
        memberService.memberDelete(id);
        return "redirect:list.do";
    }

    @GetMapping("edit.do")
    public String memberEdit(HttpServletRequest request, Model model) throws Exception {
        String id = request.getParameter("id");
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "/member/memberEdit";
    }

    @RequestMapping(value="mypage.do", method=RequestMethod.GET)
    public String myPage(Model model) throws Exception {
        String id = (String) session.getAttribute("sid");
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "/member/mypage";
    }

    @GetMapping("login.do")
    public String login(Model model) throws Exception {
        return "/member/login";
    }

    // 로그인을 컨트롤러에서 처리
    @PostMapping("signin.do")
    public String memberSignIn(@RequestParam String id, @RequestParam String pw, Model model) throws Exception {
        Member mem = memberService.signIn(id);
        if(mem != null) {
            boolean loginSuccess = pwdEncoder.matches(pw, mem.getPw());
            if(loginSuccess) {
                session.setAttribute("member", mem);
                session.setAttribute("sid", id);
                return "redirect:/";
            } else {
                return "redirect:login.do";
            }
        } else {
            return "redirect:login.do";
        }
    }

    // 로그인을 서비스에서 처리
    @RequestMapping(value = "loginpro.do", method = RequestMethod.POST)
    public String memberLogin(@RequestParam String id, @RequestParam String pw, Model model) throws Exception {
        if(memberService.loginCheck(id, pw)) {
            session.setAttribute("sid", id);
            return "redirect:/";
        } else {
            return "redirect:login.do";
        }
    }

    // 회원가입 - 회원가입 폼 페이지 로딩
    @RequestMapping("join.do")
    public String join(Model model) throws Exception {
        return "/member/join";
    }

    // 회원가입 - Ajax로 아이디 중복 체크
    @RequestMapping(value="idCheck.do", method=RequestMethod.POST)
    public void idCheck(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
        String id = request.getParameter("id");
        Member mem = memberService.getMember(id);
        boolean result = false;
        if(mem != null) {
            result = false;
        } else {
            result = true;
        }
        JSONObject json = new JSONObject();
        json.put("result", result);                 // view단의 ajax의 success function 안의 변수명과 같아야 함
        PrintWriter out = response.getWriter();
        out.println(json.toString());               // 콘솔창으로 보내짐
    }

    // 회원가입
    @RequestMapping(value="insert.do", method=RequestMethod.POST)
    public String memberWrite(Member member, Model model) throws Exception {
        String ppw = member.getPw();
        String pw = pwdEncoder.encode(ppw);
        member.setPw(pw);
        memberService.memberInsert(member);

        return "redirect:login.do";
    }

    // 로그아웃
    @RequestMapping("logout.do")
    public String memberLogout() throws Exception {
        session.invalidate();
        return "redirect:/";
    }
}
