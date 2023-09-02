package com.med.app.backend.user.model;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

/**
 * User class to represent user entity
 *
 * @author A.Antonov
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;


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


    public String getFirstName()
    {
        return firstName;
    }


    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    public String getLastName()
    {
        return lastName;
    }


    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getPhone()
    {
        return phone;
    }


    public void setPhone(String phone)
    {
        this.phone = phone;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && password.equals(user.password) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, password, firstName, lastName, email, phone);
    }
}
