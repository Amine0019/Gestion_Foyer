package tn.esprit.gestion_foyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_foyer.entities.Universite;
import tn.esprit.gestion_foyer.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universiteController")
@AllArgsConstructor
public class UniversiteController {
    final IUniversiteService universiteService;
    @PostMapping("/addUniversite")
    Universite addUniversite(@RequestBody Universite universite){
        return universiteService.addOrUpdateUniversite(universite);
    }

    @PutMapping("/updateUniversite")
    Universite updateUniversite(@RequestBody Universite universite){
        return universiteService.addOrUpdateUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite")
    void deleteUniversite(@RequestParam long idUniversite){
        universiteService.deleteUniversite(idUniversite);
    }

    @GetMapping("/findAllUniversite")
    List<Universite> findAllUniversite(){
        return universiteService.findAllUniversites();
    }

    @GetMapping("/findUniversite")
    Universite findUniversiteById(@RequestParam long idUniversite){
        return universiteService.findUniversiteById(idUniversite);
    }

}
