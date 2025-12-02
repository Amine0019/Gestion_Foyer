package tn.esprit.gestion_foyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestion_foyer.entities.Chambre;
import tn.esprit.gestion_foyer.services.EtudiantChambreService;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantChambreController {

    final EtudiantChambreService etudiantChambreService;

    @GetMapping("/chambre")
    public Chambre getChambreByCin(@RequestParam long cin) {
        return etudiantChambreService.getChambreByCin(cin);
    }
}

