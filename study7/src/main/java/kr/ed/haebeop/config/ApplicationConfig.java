package kr.ed.haebeop.config;

import kr.ed.haebeop.persistence.RestDAO;
import kr.ed.haebeop.persistence.UserPersistence;
import kr.ed.haebeop.persistence.UserPersistenceImpl;
import kr.ed.haebeop.service.RestService;
import kr.ed.haebeop.service.UserService;
import kr.ed.haebeop.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "kr.ed.haebeop")
public class ApplicationConfig {

    @Bean
    public UserService userService() { return new UserServiceImpl(); }

    @Bean
    public UserPersistence userPersistence() { return new UserPersistenceImpl(); }

    @Bean
    public RestService restService() { return new RestService(); }

    @Bean
    public RestDAO restDAO() { return new RestDAO(); }

}
