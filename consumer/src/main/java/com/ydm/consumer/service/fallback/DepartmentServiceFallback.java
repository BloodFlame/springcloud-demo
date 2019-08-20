package com.ydm.consumer.service.fallback;

import com.ydm.consumer.domain.Department;
import com.ydm.consumer.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
@RequestMapping("/fallback/department")
@Slf4j
public class DepartmentServiceFallback implements DepartmentService {
    @Override
    public boolean addDepartment(Department department) {
        log.error("服务降级了");
        return false;
    }

    @Override
    public boolean removeDepartmentById(int id) {
        log.error("服务降级了");
        return false;
    }

    @Override
    public boolean modifyDepartment(Department department) {
        log.error("服务降级了");
        return false;
    }

    @Override
    public Department getDepartmentById(int id) {
        log.error("服务降级了");
        return null;
    }

    @Override
    public Department queryDepartment(String name) {
        log.error("服务降级了");
        return null;
    }

    @Override
    public List<Department> listAllDepartments() {
        log.error("服务降级了");
        return new ArrayList<Department>();
    }
}
