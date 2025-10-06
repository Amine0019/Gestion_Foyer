package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestion_foyer.entities.Bloc;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
