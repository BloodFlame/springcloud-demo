package com.ydm.provider.controller;

import com.ydm.provider.domain.Department;

import java.util.List;

public interface DepartmentController {
    public boolean addDepartment(Department department);
    public boolean removeDepartment(int id);
    public boolean updateDepartment(Department department);
    public Department getDepartment(int id);
    public Department queryDepartment(String name);
    public List<Department> listDepartment();
}
