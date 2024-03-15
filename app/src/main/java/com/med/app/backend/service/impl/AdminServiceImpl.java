package com.med.app.backend.service.impl;

import com.med.app.backend.model.user.Admin;
import com.med.app.backend.repository.user.AdminRepository;
import com.med.app.backend.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    AdminRepository adminRepository;


    @Override
    public Admin saveAdmin(Admin admin)
    {
        return adminRepository.save(admin);
    }


    @Override
    public List<Admin> fetchAllAdmins()
    {
        return adminRepository.findAll();
    }


    @Override
    public void deleteAdminById(UUID uuid)
    {
        adminRepository.deleteById(uuid);
    }
}
