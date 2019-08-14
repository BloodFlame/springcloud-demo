package com.ydm.consumer.service;

import com.ydm.consumer.domain.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("msc-provider")
@RequestMapping("/provider/department")
public interface DepartmentService {
    @PostMapping("/add")
    boolean addDepartment(@RequestBody Department department);
    @DeleteMapping("/del/{id}")
    boolean removeDepartmentById(@PathVariable int id);
    @PutMapping("/update")
    boolean modifyDepartment(@RequestBody Department department);
    @GetMapping("/get/{id}")
    Department getDepartmentById(@PathVariable int id);
    @GetMapping("/query")
    Department queryDepartment(@RequestParam String name);
    @GetMapping("/list")
    List<Department> listAllDepartments();
}
