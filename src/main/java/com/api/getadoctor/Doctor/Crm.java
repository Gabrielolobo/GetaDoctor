package com.api.getadoctor.Doctor;

public class Crm {
    private String crm;
    private String uf;
    private String specialty; 


    public Crm(String crm,
               String uf,
               String specialty
               ) {
        this.crm = crm;
        this.uf = uf;
        this.specialty = specialty;

    }


    public String getCrm() {
        return crm;
    }


    public void setCrm(String crm) {
        this.crm = crm;
    }


    public String getUf() {
        return uf;
    }


    public void setUf(String uf) {
        this.uf = uf;
    }


    public String getSpecialty() {
        return specialty;
    }


    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


    @Override
    public String toString() {
        return "{crm=" + crm + '\'' +
                ", specialty=' " + specialty + '\'' + 
                ", uf=" + uf +
                "}";
    }
}