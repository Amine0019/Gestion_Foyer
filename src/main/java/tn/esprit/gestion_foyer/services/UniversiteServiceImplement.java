package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Universite;
import tn.esprit.gestion_foyer.repositories.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteServiceImplement implements IUniversiteService{
    final UniversiteRepository universiteRepository;
    @Override
    public Universite addOrUpdateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public List<Universite> findAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findUniversiteById(long id) {
        return universiteRepository.findById(id).get();
    }
}
