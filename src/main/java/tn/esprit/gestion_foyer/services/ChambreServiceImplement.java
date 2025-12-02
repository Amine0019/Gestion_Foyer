package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Bloc;
import tn.esprit.gestion_foyer.entities.Chambre;
import tn.esprit.gestion_foyer.entities.TypeChambre;
import tn.esprit.gestion_foyer.repositories.ChambreRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreServiceImplement implements  IChambreService{
    final ChambreRepository chambreRepository;
    @Override
    public Chambre addOrUpdateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }


    @Override
    public Chambre findChambreById(long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public List<Chambre> findByType(TypeChambre type) {
        return chambreRepository.findByTypeChambre(type);
    }

    @Override
    public Chambre findByNumero(long numero) {
        return chambreRepository.findByNumeroChambre(numero);
    }

}
