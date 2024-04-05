package com.emsi.Hospital.service;

import com.emsi.Hospital.entities.Consultation;
import com.emsi.Hospital.entities.Medecin;
import com.emsi.Hospital.entities.Patient;
import com.emsi.Hospital.entities.RendezVous;

public interface IHospitalService {
    public Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
