package tn.esprit.gestion_foyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_foyer.entities.Chambre;
import tn.esprit.gestion_foyer.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambreController")
@AllArgsConstructor
public class ChambreController {
    final IChambreService chambreService;
    @PostMapping("/addChambre")
    Chambre addChambre(@RequestBody Chambre chambre){
        return chambreService.addOrUpdateChambre(chambre);
    }

    @PutMapping("/updateChambre")
    Chambre updateChambre(@RequestBody Chambre chambre){
        return chambreService.addOrUpdateChambre(chambre);
    }

    @DeleteMapping("/deleteChambre")
    void deleteChambre(@RequestParam long  idChambre){
        chambreService.deleteChambre(idChambre);
    }

    @GetMapping("/findAllChambre")
    List<Chambre> findAllChambre(){
        return chambreService.findAll();
    }

    @GetMapping("/findChambre")
    Chambre findChambreById(@RequestParam long idChambre){
        return chambreService.findChambreById(idChambre);
    }
}
