package com.med.app.backend.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;


/**
 * Patient class to represent Patient entity.
 * <p>
 * Extends user class.
 *
 * @author A.Antonov
 */
@Entity
@Table(name = "patients")
public class Patient extends User
{
    @Column(name = "pin")
    private String pin;

    // TODO: Think about GP of patient
    // TODO: Constructors?

    public String getPin()
    {
        return pin;
    }


    public void setPin(String pin)
    {
        this.pin = pin;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return pin.equals(patient.pin);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), pin);
    }
}
