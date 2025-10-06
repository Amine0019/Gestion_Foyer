package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestion_foyer.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
