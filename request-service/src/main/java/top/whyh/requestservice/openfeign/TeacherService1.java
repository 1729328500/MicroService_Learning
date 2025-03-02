package top.whyh.requestservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.whyh.requestservice.controller.TeacherRequest;

@FeignClient(value = "python-service")
public interface TeacherService1 {

    @GetMapping("/teacher")
    String getTeachers();

    @PostMapping("/teacher")
    String createTeacher(@RequestBody TeacherRequest request);

    @PutMapping("/teacher/{id}")
    String updateTeacher(@PathVariable Integer id, @RequestBody TeacherRequest request);

    @DeleteMapping("/teacher/{id}")
    String deleteTeacher(@PathVariable Integer id);
}