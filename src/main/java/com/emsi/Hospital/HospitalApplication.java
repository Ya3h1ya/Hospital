package com.emsi.Hospital;

import com.emsi.Hospital.entities.*;
import com.emsi.Hospital.repositories.ConsultationRepository;
import com.emsi.Hospital.repositories.MedecinRepository;
import com.emsi.Hospital.repositories.PatientRepository;
import com.emsi.Hospital.repositories.RendezVousRepository;
import com.emsi.Hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

	public static void main(String[] args) {

		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
	                         PatientRepository patientRepository,
							 RendezVousRepository rendezVousRepository,
							MedecinRepository medecinRepository){
		return args -> {
			Stream.of("lupo","Yahya","Ayhay")
					.forEach(name->{
						Patient patient=new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("Mounir.D","Khalid.B","Smail.M")
					.forEach(name->{
						Medecin medecin=new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialiste(Math.random()>0.5?"Cardio":"Dentiste");
						hospitalService.saveMedecin(medecin);
					});
               Patient patient=patientRepository.findById(1L).orElse(null);
			   Patient patient1=patientRepository.findByNom("Lupo");

			   Medecin medecin=medecinRepository.findByNom("Mounir.D");
			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
            RendezVous saveRDV= hospitalService.saveRDV(rendezVous);
            System.out.println(saveRDV.getId());


			RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation......");
			hospitalService.saveConsultation(consultation);

		};

	}

}
