package top.whyh.nacosconfigservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.whyh.nacosconfigservice.entity.Teacher;
import top.whyh.nacosconfigservice.mapper.TeacherMapper;
import top.whyh.nacosconfigservice.service.TeacherService;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}