package com.api.getadoctor.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String>{
       // SELECT * FROM student WHERE email = ?
       @Query("SELECT s FROM Doctor s WHERE s.email = ?1")
       Optional<Doctor> findDoctorByEmail(String email);

       boolean existsById(Long doctorId);

       void deleteById(Long doctorId);

       Doctor findById(Long doctorId); 
}
