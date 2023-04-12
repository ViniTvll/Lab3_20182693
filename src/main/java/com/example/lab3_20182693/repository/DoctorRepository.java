package com.example.lab3_20182693.repository;
import com.example.lab3_20182693.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findByNombre(String name);

    @Query(nativeQuery = true,value = "select * from hospitales where Nombre = ?1")
    List<Doctor> buscarPorNombre(String nombre);



}
