package com.api.getadoctor.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//http;//localhost:8080/api/v1/doctor

@RestController
@RequestMapping (path = "api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;
    
    @Autowired
    public DoctorController (DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
	public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
		}

    
    @PostMapping
    public void registerNewDoctor (@RequestBody Doctor doctor) {
        doctorService.addNewDoctor(doctor);
    }


    @DeleteMapping(path = "{doctorId}")
    public void deleteDoctor(@PathVariable("doctorId") Long doctorId) {
        doctorService.deleteDoctor(doctorId);
    }

    @PutMapping(path = "{doctorId}")
    public void updateDoctor(
        @PathVariable("doctorId") Long doctorId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email) {
            doctorService.updateDoctor(doctorId, name, email);
        }
}
