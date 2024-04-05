package com.emsi.Hospital.repositories;

import com.emsi.Hospital.entities.Medecin;
import com.emsi.Hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

    Medecin findByNom(String name);
}
