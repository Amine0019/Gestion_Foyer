package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Foyer;
import tn.esprit.gestion_foyer.repositories.FoyerRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerServiceImplement implements IFoyerService{
    final FoyerRepository foyerRepository;
    @Override
    public Foyer addOrUpdateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public List<Foyer> findAllFoyers() {
        return foyerRepository.findAll();

    }

    @Override
    public Foyer findFoyerById(long id) {
        return foyerRepository.findById(id).get();
    }
}
