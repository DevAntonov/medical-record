package com.med.app.backend.model.record;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tMedicalNotes")
public class MedicalNote
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;
    @JsonIgnore
    @OneToOne(mappedBy = "medicalNote")
    private Record record;
    @Column(name = "cDateFrom", nullable = false)
    private Date dateFrom;
    @Column(name = "cDateTo", nullable = false)
    private Date dateTo;


    public UUID getId()
    {
        return id;
    }


    public void setId(UUID id)
    {
        this.id = id;
    }


    public Record getRecord()
    {
        return record;
    }


    public void setRecord(Record record)
    {
        this.record = record;
    }


    public Date getDateFrom()
    {
        return dateFrom;
    }


    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }


    public Date getDateTo()
    {
        return dateTo;
    }


    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof MedicalNote that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(dateFrom, that.dateFrom) && Objects.equals(dateTo, that.dateTo);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id, dateFrom, dateTo);
    }
}
