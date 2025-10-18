package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Bloc;

import java.util.List;


public interface IBlocService {
    Bloc addOrUpdate(Bloc bloc);
    void deleteBloc(long id);
    List<Bloc> findAllBloc();
    Bloc findBlocById(long id);
}
