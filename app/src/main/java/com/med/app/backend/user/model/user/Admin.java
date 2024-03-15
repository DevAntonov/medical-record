package com.med.app.backend.user.model.user;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;


/**
 * Admin class to represent Admin entity
 *
 * @author A.Antonov
 */
@Entity
@Table(name = "tAdmins")
public class Admin
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;
    @Column(name = "cPassword")
    private String password;


    public UUID getId()
    {
        return id;
    }


    public void setId(UUID id)
    {
        this.id = id;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id.equals(admin.id) && password.equals(admin.password);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, password);
    }
}
