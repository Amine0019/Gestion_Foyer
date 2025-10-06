package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestion_foyer.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
