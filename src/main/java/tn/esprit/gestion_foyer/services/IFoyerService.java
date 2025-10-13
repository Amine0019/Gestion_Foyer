package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addOrUpdateFoyer(Foyer foyer);
    void deleteFoyer(long id);
    List<Foyer> findAllFoyers();
    Foyer findFoyerById(long id);
}
