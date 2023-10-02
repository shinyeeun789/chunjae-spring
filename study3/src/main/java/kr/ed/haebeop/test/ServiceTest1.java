package kr.ed.haebeop.test;

import kr.ed.haebeop.config.ApplicationConfig;
import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ServiceTest1 {

    @Autowired
    private static TestService testService;

    public static void main(String[] args) throws Exception{
        testList2();
    }

    public static void testList() throws Exception {
        List<TestVO> testList = testService.testList();
        for(TestVO test : testList){
            System.out.println(test.toString());
        }
    }

    public static void testList2() throws Exception {
        AnnotationConfigApplicationContext factory
                = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        TestService testService3 = (TestService) factory.getBean("testService3");
        List<TestVO> testList = testService3.testList();
        for(TestVO test : testList) {
            System.out.println(test.toString());
        }
    }
}
