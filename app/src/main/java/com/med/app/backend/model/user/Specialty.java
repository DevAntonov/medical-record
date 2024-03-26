package com.med.app.backend.model.user;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tSpecialty")
public class Specialty
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;
    @Column(name = "cSpecialtyId", unique = true, nullable = false, length = 6)
    private String specialtyId;
    @Column(name = "cName", unique = true, nullable = false)
    private String name;


    public UUID getId()
    {
        return id;
    }


    public void setId(UUID id)
    {
        this.id = id;
    }


    public String getSpecialtyId()
    {
        return specialtyId;
    }


    public void setSpecialtyId(String specialtyId)
    {
        this.specialtyId = specialtyId;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Specialty specialty)) return false;
        return Objects.equals(id, specialty.id) && Objects.equals(specialtyId, specialty.specialtyId) && Objects.equals(name, specialty.name);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, specialtyId, name);
    }
}
