package com.med.app.backend.model.user;

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
    @Column(name = "cUsername")
    private String username;
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


    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username;
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
        if (!(o instanceof Admin admin)) return false;
        return Objects.equals(id, admin.id) && Objects.equals(username, admin.username) && Objects.equals(password, admin.password);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, username, password);
    }
}
