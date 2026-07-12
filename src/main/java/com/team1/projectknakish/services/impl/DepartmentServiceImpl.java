package com.team1.projectknakish.services.impl;

import com.team1.projectknakish.domain.entities.Department;
import com.team1.projectknakish.repositories.DepartmentRepository;
import com.team1.projectknakish.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
