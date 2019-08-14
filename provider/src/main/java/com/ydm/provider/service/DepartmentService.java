package com.ydm.provider.service;

import com.ydm.provider.domain.Department;

import java.util.List;

public interface DepartmentService {
    boolean addDepartment(Department department);
    boolean removeDepartmentById(int id);
    boolean modifyDepartment(Department department);
    Department getDepartmentById(int id);
    Department queryDepartment(String name);
    List<Department> listAllDepartments();
}
