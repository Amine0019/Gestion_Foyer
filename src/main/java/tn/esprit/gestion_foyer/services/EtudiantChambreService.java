package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Chambre;
import tn.esprit.gestion_foyer.repositories.ReservationRepository;

@Service
@AllArgsConstructor
public class EtudiantChambreService {

    final ReservationRepository reservationRepository;

    public Chambre getChambreByCin(long cin) {
        return reservationRepository.findChambreByCin(cin);
    }
}

