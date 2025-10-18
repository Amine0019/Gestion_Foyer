package tn.esprit.gestion_foyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_foyer.entities.Etudiant;
import tn.esprit.gestion_foyer.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiantController")
@AllArgsConstructor
public class EtudiantController {
    final IEtudiantService etudiantService;
    @PostMapping("/addEtudiant")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @PutMapping("/updateEtudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addOrUpdateEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant")
    void deleteEtudiant(@RequestParam long idEtudiant){
        etudiantService.deleteEtudiant(idEtudiant);
    }

    @GetMapping("/findAllEtudiant")
    List<Etudiant> findAllEtudiant(){
        return etudiantService.findAll();
    }

    @GetMapping("/findEtudiant")
    Etudiant findEtudiant(@RequestParam long idEtudiant){
        return etudiantService.findEtudiantById(idEtudiant);
    }
}
