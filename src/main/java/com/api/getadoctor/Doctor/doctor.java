package com.api.getadoctor.Doctor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Doctor {
    
    @Id
    @SequenceGenerator(
        name = "Doctor_sequence",
        sequenceName = "Doctor_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "Doctor_sequence"
    )

    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;

    public Doctor() {}

    public Doctor(String email,
                  String password,
                  String name,
                  String surname, 
                  String phone) {
        
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Doctor{" +
               "ID = " + id +
               ", Name =' " + name + '\'' +
               ", Surname =' " + surname + '\'' +
               ", E-mail =' " + email + '\'' +
               ", Password =' " + password + '\'' +
               ", Phone = " + phone +
               '}';
    }
}
   
