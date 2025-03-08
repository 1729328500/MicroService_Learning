package top.whyh.nacosconfigservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whyh.nacosconfigservice.entity.Teacher;
import top.whyh.nacosconfigservice.service.TeacherService;

import java.util.List;

@RestController
@RefreshScope
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.list();
    }
}