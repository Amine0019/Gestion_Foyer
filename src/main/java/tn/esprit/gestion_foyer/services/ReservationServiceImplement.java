package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Reservation;
import tn.esprit.gestion_foyer.repositories.ReservationRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ReservationServiceImplement implements IReservationService{
    final ReservationRepository reservationRepository;
    @Override
    public Reservation addOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> findAllReservations() {
       return reservationRepository.findAll();
    }

    @Override
    public Reservation findReservationById(String id) {
        return reservationRepository.findById(id).get();
    }
}
