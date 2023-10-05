package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// REST(Representational State Transfer) : 해당 자원의 상태를 주고받는 모든 것
// RESTful API : JSON으로 데이터를 주고 받는 api
@RestController
@RequestMapping("/api/")
public class ApiController {

    @GetMapping("api1")                 // RestController의 GET을 활용한 Student 반환
    public Student getStudent() {
        Student std1 = new Student(101, "김이름", 8);
        return std1;
    }

    @GetMapping("api2")                     // RestController의 Get을 활용한 Student List 반환
    public ArrayList<Student> getAllStudent() {
        Student std1 = new Student(101, "김이름", 8);
        Student std2 = new Student(102, "이이름", 9);
        Student std3 = new Student(103, "박이름", 10);
        ArrayList<Student> stds = new ArrayList<>();
        stds.add(std1);
        stds.add(std2);
        stds.add(std3);
        return stds;
    }

    @PostMapping("api4")
    public String postStudent(@RequestBody Student std) {
        String response = String.format("<학생 정보>\n이름 : %s\n나이 : %d", std.getName(), std.getStdNum(), std.getAge());
        return response;
    }



}
