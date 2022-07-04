package com.api.getadoctor.Doctor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Spring Bean
public class DoctorService {

    private final DoctorRepository doctorRepository;
    
    @Autowired
    public DoctorService( DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors() {
		return doctorRepository.findAll();
    }

    public void addNewDoctor( Doctor doctor) {
        Optional<Doctor> doctorOptional = doctorRepository
                .findDoctorByEmail(doctor.getEmail());
        if (doctorOptional.isPresent()) {
            throw new IllegalStateException("This e-mail is already in use.");
        }
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long doctorId) {
        boolean exists = doctorRepository.existsById(doctorId);
        if(!exists) {
            throw new IllegalStateException(
                "doctor with id" + doctorId + "does not exist");
        }
        doctorRepository.deleteById(doctorId);
    }

    @Transactional    
    public void updateDoctor(Long doctorId, String name, String email) 
    throws IllegalStateException {
        Doctor doctor = doctorRepository.findById(doctorId);

        if (doctor == null) {
            throw new IllegalStateException("doctor id " + doctorId + "does not exist");
        }
        
        if (
            name != null &&
            name.length() > 0 &&
            !Objects.equals(doctor.getName(), name)
        ) {
            doctor.setName(name);
        }

        if (
            email != null &&
            email.length() > 0 &&
            Objects.equals(doctor.getEmail(), email)
            ) {
            Optional<Doctor> doctorOptional = doctorRepository
                    .findDoctorByEmail(email);

            if (doctorOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            doctor.setEmail(email);           
        }
    }
}