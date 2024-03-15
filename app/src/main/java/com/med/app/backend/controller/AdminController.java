package com.med.app.backend.controller;


import com.med.app.backend.model.user.Admin;
import com.med.app.backend.service.api.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController
{
    @Autowired
    AdminService adminService;


    @PostMapping("/admins")
    public Admin saveAdmin(@Valid @RequestBody Admin admin)
    {
        return adminService.saveAdmin(admin);
    }


    @GetMapping("/admins")
    public List<Admin> fetchAllAdmins()
    {
        return adminService.fetchAllAdmins();
    }
}
