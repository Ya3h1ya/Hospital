package com.emsi.Hospital.web;

import com.emsi.Hospital.entities.Patient;
import com.emsi.Hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PatientRestContoller {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/Patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
