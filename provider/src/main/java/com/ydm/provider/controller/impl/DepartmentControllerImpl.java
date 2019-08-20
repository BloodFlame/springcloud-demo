package com.ydm.provider.controller.impl;

import com.ydm.provider.controller.DepartmentController;
import com.ydm.provider.domain.Department;
import com.ydm.provider.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/department")
public class DepartmentControllerImpl implements DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    @Override
    public boolean addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @DeleteMapping("/del/{id}")
    @Override
    public boolean removeDepartment(@PathVariable int id) {
        return departmentService.removeDepartmentById(id);
    }

    @PutMapping("/update")
    @Override
    public boolean updateDepartment(@RequestBody Department department) {
        return departmentService.modifyDepartment(department);
    }

    @GetMapping("/get/{id}")
    @Override
    public Department getDepartment(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/query")
    @Override
    public Department queryDepartment(@RequestParam String name) {
        return departmentService.queryDepartment(name);
    }

    @GetMapping("/list")
    @Override
    public List<Department> listDepartment() {
        return departmentService.listAllDepartments();
    }
}
