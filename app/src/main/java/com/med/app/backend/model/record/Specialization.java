package com.med.app.backend.model.record;


import com.med.app.backend.model.user.Doctor;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tSpecializations")
public class Specialization
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;
    @Column(name = "cSpecializationId", unique = true, nullable = false, length = 6)
    private String specialtyId;
    @Column(name = "cName", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "specializations")
    private Set<Doctor> doctors;


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


    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Specialization specialization)) return false;
        return Objects.equals(id, specialization.id) && Objects.equals(specialtyId, specialization.specialtyId) && Objects.equals(name, specialization.name);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, specialtyId, name);
    }
}
