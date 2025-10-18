package tn.esprit.gestion_foyer.services;

import tn.esprit.gestion_foyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addOrUpdateReservation(Reservation reservation);
    void deleteReservation(String id);
    List<Reservation> findAllReservations();
    Reservation findReservationById(String id);
}
