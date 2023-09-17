package com.example.hello.controller;

import com.example.hello.domain.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")//truy cap den student
public class StudentController {
    //them 2 truong request va response, su dung autowired giup container nhan biet va tiêm các đối tượng"HttpServletRequest/Response" vào cho 2 biến req và res
    final
    HttpServletRequest request;
    final
    HttpServletResponse response;

    public StudentController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @GetMapping("create")
    //truy cap action nay thong qua get method cua http
    public String create(){
        return "createStudent";
    }
    @PostMapping("create") //de khai bao va xac dinh URL dung de truy cap den phuong thuc createPost la create
    public String createPost(){
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        Student student = new Student(studentId,name);
        request.setAttribute("student",student);
        return "detailStudent";
    }
}
