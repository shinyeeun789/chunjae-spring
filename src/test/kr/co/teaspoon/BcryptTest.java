package kr.co.teaspoon;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {

    public static void main(String[] args) {
        String pw = "1234";
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

        System.out.println(pwdEncoder.encode(pw));
    }

}
