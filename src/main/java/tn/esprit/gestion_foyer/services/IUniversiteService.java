package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addOrUpdateUniversite(Universite universite);
    void deleteUniversite(long id);
    List<Universite> findAllUniversites();
    Universite findUniversiteById(long id);
}
