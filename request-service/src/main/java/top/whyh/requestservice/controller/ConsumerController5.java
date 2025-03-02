package top.whyh.requestservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.whyh.requestservice.openfeign.TeacherService;

@RestController
@RequestMapping("/teachers")
public class ConsumerController5 {

    @Resource
    private TeacherService teacherService;

    // 查询接口
    @GetMapping
    public String getAllTeachers() {
        return teacherService.getTeachers();
    }

    // 创建接口
    @PostMapping
    public String createTeacher(@RequestBody TeacherRequest request) {
        return teacherService.createTeacher(request);
    }

    // 更新接口
    @PutMapping("/{id}")
    public String updateTeacher(
            @PathVariable Integer id,
            @RequestBody TeacherRequest request
    ) {
        return teacherService.updateTeacher(id, request);
    }

    // 删除接口
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Integer id) {
        return teacherService.deleteTeacher(id);
    }
}

