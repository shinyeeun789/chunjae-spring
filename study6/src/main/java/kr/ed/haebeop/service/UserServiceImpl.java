package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.User;
import kr.ed.haebeop.persistence.UserPersistence;
import kr.ed.haebeop.persistence.UserPersistenceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserPersistence userPersistence;

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
        boolean result = false;
        User user = new User();
        user.setId(request.getParameter("id"));
        user.setPw(request.getParameter("pw"));
        if(userPersistence.login(user) != null) {
            result = true;
        }
        return result;
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
