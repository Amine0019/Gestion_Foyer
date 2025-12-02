package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Bloc;

import java.util.List;


public interface IBlocService {
    Bloc addOrUpdate(Bloc bloc);
    void deleteBloc(long id);
    List<Bloc> findAllBloc();
    Bloc findBlocById(long id);
    Bloc addBlocAndAssignFoyer(Bloc bloc, long idFoyer);
    Bloc assignBlocToFoyer(long idBloc, long idFoyer);
    Bloc unassignBlocFromFoyer(long idBloc);
    List<Bloc> getBlocsSansFoyer();
    List<Bloc> getBlocsCapaciteSup30();
    List<Bloc> getBlocsNomCommencePar(String lettre);
    List<Bloc> getBlocsNomCommenceParEtCapSup(String lettre, int capacite);

}
