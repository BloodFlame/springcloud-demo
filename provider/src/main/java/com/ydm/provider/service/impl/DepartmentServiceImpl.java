package com.ydm.provider.service.impl;

import com.ydm.provider.dao.DepartmentMapper;
import com.ydm.provider.domain.Department;
import com.ydm.provider.domain.DepartmentExample;
import com.ydm.provider.exception.NotFoundDepartmentException;
import com.ydm.provider.service.DepartmentService;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public boolean addDepartment(Department department) {
        int ret = departmentMapper.insert(department);
        return ret==1;
    }

    @Override
    public boolean removeDepartmentById(int id) {
        int ret = departmentMapper.deleteByPrimaryKey(id);
        return ret==1;
    }

    @Override
    public boolean modifyDepartment(Department department) {
        int ret = departmentMapper.updateByPrimaryKey(department);
        return ret==1;
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Department queryDepartment(String name) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andNameEqualTo(name);
        List<Department> result = departmentMapper.selectByExample(departmentExample);
        if(result.size() < 1) throw new NotFoundDepartmentException();
        return result.get(0);
    }

    @Override
    public List<Department> listAllDepartments() {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.setOrderByClause("id desc");
        return departmentMapper.selectByExample(departmentExample);
    }
}
