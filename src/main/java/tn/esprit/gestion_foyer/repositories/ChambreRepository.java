package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_foyer.entities.Chambre;
import tn.esprit.gestion_foyer.entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    // 1. Liste des chambres par type
    List<Chambre> findByTypeChambre(TypeChambre typeChambre);

    // 2. Chambre par numéro
    Chambre findByNumeroChambre(long numeroChambre);
}
