package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_foyer.entities.Chambre;
import tn.esprit.gestion_foyer.entities.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    @Query("SELECT r.chambre FROM Reservation r JOIN r.typeEtudiant e WHERE e.cin = :cin")
    Chambre findChambreByCin(@Param("cin") long cin);
}
