package tn.esprit.gestion_foyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_foyer.entities.Foyer;
import tn.esprit.gestion_foyer.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyerController")
@AllArgsConstructor
public class FoyerController {
    final IFoyerService foyerService;
    @PostMapping("/addFoyer")
    Foyer addFoyer(@RequestBody Foyer foyer){
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @PutMapping("/updateFoyer")
    Foyer updateFoyer(@RequestBody Foyer foyer){
        return foyerService.addOrUpdateFoyer(foyer);
    }

    @DeleteMapping("/deleteFoyer")
    void deleteFoyer(@RequestBody long  idFoyer){
        foyerService.deleteFoyer(idFoyer);
    }

    @GetMapping("/findAllFoyer")
    List<Foyer> findAllFoyer(){
        return foyerService.findAllFoyers();
    }

    @GetMapping("/findFoyer")
    Foyer findFoyer(@RequestParam long idFoyer){
        return foyerService.findFoyerById(idFoyer);
    }

    

}
