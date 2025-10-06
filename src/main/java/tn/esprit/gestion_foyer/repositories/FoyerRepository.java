package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_foyer.entities.Foyer;
@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
}
