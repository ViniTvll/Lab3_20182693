package com.example.lab3_20182693.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "hospitales")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospitalid")
    private int hospitalId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "dirección")
    private String dirección;
    @Column(name = "telefono")
    private String telefono;

    public int getHospitalid() {
        return hospitalId;
    }

    public void setHospitalid(int hospitalid) {
        this.hospitalId = hospitalid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
