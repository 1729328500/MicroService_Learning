package top.whyh.requestservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.whyh.requestservice.controller.TeacherRequest;

// TeacherService.java
@FeignClient(value = "node-service")
public interface TeacherService {

    // 修改前：@GetMapping("/getTeacher")
    // 修改后：匹配 Node.js 的实际路径
    @GetMapping(value = "/api/teacher")
    String getTeachers();

    // 其他接口同理修正路径
    @PostMapping(value = "/api/teacher", consumes = "application/json")
    String createTeacher(@RequestBody TeacherRequest request);


    @PutMapping(value = "/api/teacher/{id}",consumes = "application/json")
    String updateTeacher(@PathVariable Integer id, @RequestBody TeacherRequest request);

    @DeleteMapping(value = "/api/teacher/{id}")
    String deleteTeacher(@PathVariable Integer id);
}