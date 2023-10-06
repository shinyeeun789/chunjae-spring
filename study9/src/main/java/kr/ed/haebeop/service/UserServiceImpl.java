package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.User;
import kr.ed.haebeop.persistence.UserPersistence;
import kr.ed.haebeop.persistence.UserPersistenceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserPersistence userPersistence;

    @Inject
    BCryptPasswordEncoder pwdEncoder;

    @Override
    public List<User> userList() throws Exception {
        return userPersistence.userList();
    }

    @Override
    public User getUser(String id) throws Exception {
        return userPersistence.getUser(id);
    }

    @Override
    public void userInsert(User dto) throws Exception {
        userPersistence.userInsert(dto);
    }

    @Override
    public User signIn(User mdto) throws Exception {
        return userPersistence.signIn(mdto);
    }

    @Override
    public User loginCheck(User mdto) throws Exception {
        return userPersistence.loginCheck(mdto);
    }

    @Override
    public boolean login(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        boolean loginSuccess = false;
        User mdto = new User();

        mdto.setId(request.getParameter("id"));
        mdto.setPw(request.getParameter("pw"));

        User login = userPersistence.login(mdto);

        loginSuccess = pwdEncoder.matches(mdto.getPw(), login.getPw());
        if(login != null && loginSuccess) {
            session.setAttribute("user", login);
            session.setAttribute("sid", login.getId());
        }
        return loginSuccess;
    }

    @Override
    public void userUpdate(User mdto) throws Exception {
        userPersistence.userUpdate(mdto);
    }

    @Override
    public void userDelete(String id) throws Exception {
        userPersistence.userDelete(id);
    }
}
