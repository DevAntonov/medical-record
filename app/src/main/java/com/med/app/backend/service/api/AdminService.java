package com.med.app.backend.service.api;

import com.med.app.backend.model.user.Admin;

import java.util.List;
import java.util.UUID;

public interface AdminService
{
    Admin saveAdmin(Admin admin);

    List<Admin> fetchAllAdmins();

    void deleteAdminById(UUID uuid);
}
