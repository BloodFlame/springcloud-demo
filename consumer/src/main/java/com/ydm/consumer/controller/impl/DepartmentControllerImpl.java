package com.ydm.consumer.controller.impl;

import com.ydm.consumer.controller.DepartmentController;
import com.ydm.consumer.domain.Department;
import com.ydm.consumer.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/department")
@Slf4j
@RefreshScope
public class DepartmentControllerImpl implements DepartmentController {
    @Value("${info.user}")
    private String admin_user;

    @Autowired
    private DepartmentService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    @Override
    public Boolean addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    @DeleteMapping("/del/{id}")
    @Override
    public Boolean removeDepartment(@PathVariable int id) {
        return service.removeDepartmentById(id);
    }

    @PutMapping("/update")
    @Override
    public Boolean updateDepartment(@RequestBody Department department) {
        return service.modifyDepartment(department);
    }

    @GetMapping("/get/{id}")
    @Override
    public Department getDepartment(@PathVariable int id) {
        return service.getDepartmentById(id);
    }

    @GetMapping("/query")
    @Override
    public Department queryDepartment(@RequestParam String name) {
        return service.queryDepartment(name);
    }

    @GetMapping("/list")
    @Override
    public List<Department> listDepartment() {
        log.info(admin_user);
        return service.listAllDepartments();
    }

    @GetMapping("/discovery")
    public List<String> dicoveryServices(){
        List<String> services = discoveryClient.getServices();
        return services;
    }
}
