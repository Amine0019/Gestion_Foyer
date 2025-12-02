package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Chambre;

public interface IEtudiantChambreService {
    public Chambre getChambreByCin(long cin);
}
