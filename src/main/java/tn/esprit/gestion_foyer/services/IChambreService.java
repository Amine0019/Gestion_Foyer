package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Bloc;
import tn.esprit.gestion_foyer.entities.Chambre;
import tn.esprit.gestion_foyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre addOrUpdateChambre(Chambre chambre);
    void deleteChambre(long id);
    List<Chambre> findAll();
    Chambre findChambreById(long id);
    List<Chambre> findByType(TypeChambre type);
    Chambre findByNumero(long numero);

}
