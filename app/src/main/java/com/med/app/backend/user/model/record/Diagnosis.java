package com.med.app.backend.user.model.record;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tDiagnoses")
public class Diagnosis
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;
    @Column(name = "cDiagnosisId", nullable = false, unique = true, length = 6)
    private String diagnosisId;
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


    public String getDiagnosisId()
    {
        return diagnosisId;
    }


    public void setDiagnosisId(String diagnosisId)
    {
        this.diagnosisId = diagnosisId;
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
        if (!(o instanceof Diagnosis diagnosis)) return false;
        return Objects.equals(id, diagnosis.id) && Objects.equals(diagnosisId, diagnosis.diagnosisId) && Objects.equals(name, diagnosis.name);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, diagnosisId, name);
    }
}
