package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Bloc;
import tn.esprit.gestion_foyer.repositories.BlocRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocServiceImplement implements  IBlocService{
    final BlocRepository blocRepository;
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
}
