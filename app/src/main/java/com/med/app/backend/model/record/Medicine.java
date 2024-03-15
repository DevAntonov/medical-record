package com.med.app.backend.model.record;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tMedicine")
public class Medicine
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;
    @Column(name = "cMedicineId", nullable = false, unique = true, length = 6)
    private String medicineId;
    @Column(name = "cName", nullable = false, unique = true)
    private String name;


    public UUID getId()
    {
        return id;
    }


    public void setId(UUID id)
    {
        this.id = id;
    }


    public String getMedicineId()
    {
        return medicineId;
    }


    public void setMedicineId(String medicineId)
    {
        this.medicineId = medicineId;
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
        if (!(o instanceof Medicine medicine)) return false;
        return Objects.equals(id, medicine.id) && Objects.equals(medicineId, medicine.medicineId) && Objects.equals(name, medicine.name);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, medicineId, name);
    }
}
