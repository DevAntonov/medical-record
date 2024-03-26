package com.med.app.backend.model.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.Objects;


/**
 * Doctor class to represent Doctor entity.
 * <p>
 * Extends user class
 *
 * @author A.Antonov
 */
@Entity
@PrimaryKeyJoinColumn(name = "cUserId")
@Table(name = "tDoctors")
public class Doctor extends User
{
    @Column(name = "cDoctorId")
    private String doctorId;

    // TODO: Think about doctor patient connections and doctor specialty conn


    public String getDoctorId()
    {
        return doctorId;
    }


    public void setDoctorId(String doctorId)
    {
        this.doctorId = doctorId;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(doctorId, doctor.doctorId);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), doctorId);
    }
}
