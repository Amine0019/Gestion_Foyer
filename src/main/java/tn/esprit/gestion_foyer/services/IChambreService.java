package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Bloc;
import tn.esprit.gestion_foyer.entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre addOrUpdateChambre(Chambre chambre);
    void deleteChambre(long id);
    List<Chambre> findAll();
    Chambre findChambreById(long id);
}
