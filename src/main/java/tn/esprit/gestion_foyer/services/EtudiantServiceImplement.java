package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Etudiant;
import tn.esprit.gestion_foyer.repositories.EtudiantRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceImplement implements IEtudiantService{
    final EtudiantRepository etudiantRepository;
    @Override
    public Etudiant addOrUpdateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findEtudiantById(long id) {
        return etudiantRepository.findById(id).get();
    }
}
