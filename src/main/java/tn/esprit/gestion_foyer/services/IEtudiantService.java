package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Etudiant etudiant);
    List<Etudiant> findAll();
    Etudiant findEtudiantById(long id);
}
