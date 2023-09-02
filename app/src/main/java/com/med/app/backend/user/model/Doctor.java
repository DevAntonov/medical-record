package com.med.app.backend.user.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


/**
 * Doctor class to represent Doctor entity.
 * <p>
 * Extends user class
 *
 * @author A.Antonov
 */
@Entity
@Table(name = "doctors")
public class Doctor extends User
{
    @Column(name = "doctor_id")
    private String doctorId;

    // TODO: Think about doctor patient connections and doctor specialty conn
}
