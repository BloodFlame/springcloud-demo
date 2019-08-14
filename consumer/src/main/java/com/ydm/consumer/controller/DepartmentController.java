package com.ydm.consumer.controller;

import com.ydm.consumer.domain.Department;

import java.util.List;

public interface DepartmentController {
    public Boolean addDepartment(Department department);
    public Boolean removeDepartment(int id);
    public Boolean updateDepartment(Department department);
    public Department getDepartment(int id);
    public Department queryDepartment(String name);
    public List<Department> listDepartment();
}
