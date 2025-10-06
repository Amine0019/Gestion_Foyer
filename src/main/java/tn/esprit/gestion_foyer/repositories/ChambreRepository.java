package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestion_foyer.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
}
