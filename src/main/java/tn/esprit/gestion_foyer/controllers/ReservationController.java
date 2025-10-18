package tn.esprit.gestion_foyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_foyer.entities.Reservation;
import tn.esprit.gestion_foyer.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservationController")
@AllArgsConstructor
public class ReservationController {
    final IReservationService reservationService;
    @PostMapping("/addReservation")
    Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addOrUpdateReservation(reservation);
    }

    @PutMapping("/updateReservation")
    Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.addOrUpdateReservation(reservation);
    }

    @DeleteMapping("/deleteReservation")
    void deleteReservation(@RequestParam String idReservation){
        reservationService.deleteReservation(idReservation);
    }

    @GetMapping("/findAllReservation")
    List<Reservation> findAllReservation(){
        return reservationService.findAllReservations();
    }

    @GetMapping("/findReservation")
    Reservation findReservationById(@RequestParam String idReservation){
        return reservationService.findReservationById(idReservation);
    }
}
