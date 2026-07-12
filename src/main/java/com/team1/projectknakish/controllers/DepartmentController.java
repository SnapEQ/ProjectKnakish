package com.team1.projectknakish.controllers;

import com.team1.projectknakish.domain.entities.Department;
import com.team1.projectknakish.dto.responses.DepartmentResponse;
import com.team1.projectknakish.mappers.DepartmentMapper;
import com.team1.projectknakish.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    public DepartmentController(DepartmentService departmentService, DepartmentMapper departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }

    @GetMapping
    ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        List<DepartmentResponse> departmentResponses = departments.stream().map(departmentMapper::toResponse).toList();
        return new ResponseEntity<>(departmentResponses, HttpStatus.OK);
    }
}
