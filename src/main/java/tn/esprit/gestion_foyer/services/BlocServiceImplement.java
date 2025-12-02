package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Bloc;
import tn.esprit.gestion_foyer.entities.Foyer;
import tn.esprit.gestion_foyer.repositories.BlocRepository;
import tn.esprit.gestion_foyer.repositories.FoyerRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocServiceImplement implements  IBlocService{
    final BlocRepository blocRepository;
    final FoyerRepository foyerRepository;

    @Override
    public Bloc addOrUpdate(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public List<Bloc> findAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findBlocById(long id) {
        return  blocRepository.findById(id).get();
    }

    @Override
    public Bloc addBlocAndAssignFoyer(Bloc bloc, long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        bloc.setTypeFoyer(foyer);
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc assignBlocToFoyer(long idBloc, long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        bloc.setTypeFoyer(foyer);
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc unassignBlocFromFoyer(long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        bloc.setTypeFoyer(null);
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> getBlocsSansFoyer() {
        return blocRepository.findByFoyerIsNull();
    }

    @Override
    public List<Bloc> getBlocsCapaciteSup30() {
        return blocRepository.findByCapaciteBlocGreaterThan(30);
    }

    @Override
    public List<Bloc> getBlocsNomCommencePar(String lettre) {
        return blocRepository.findByNomBlocStartingWith(lettre);
    }

    @Override
    public List<Bloc> getBlocsNomCommenceParEtCapSup(String lettre, int capacite) {
        return blocRepository.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(lettre, capacite);
    }
}
