package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestion_foyer.entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
}
