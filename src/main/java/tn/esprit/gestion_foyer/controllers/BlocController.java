package tn.esprit.gestion_foyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion_foyer.entities.Bloc;
import tn.esprit.gestion_foyer.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/blocController")
@AllArgsConstructor
public class BlocController {
    final IBlocService blocService;
    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc){
        return blocService.addOrUpdate(bloc);
    }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc){
        return blocService.addOrUpdate(bloc);
    }

    @DeleteMapping("/deleteBloc")
    void deleteBloc(@RequestParam long idBloc){
         blocService.deleteBloc(idBloc);
    }

    @GetMapping("/findAllBloc")
    public List<Bloc> findAllBloc(){
        return blocService.findAllBloc();
    }

    @GetMapping("/findProject")
    Bloc findBloc(@RequestParam long idBloc){
        return blocService.findBlocById(idBloc);
    }
    @PostMapping("/addBlocAndAssignFoyer/{idFoyer}")
    public Bloc addBlocAndAssignFoyer(@RequestBody Bloc bloc, @PathVariable long idFoyer) {
        return blocService.addBlocAndAssignFoyer(bloc, idFoyer);
    }

    @PutMapping("/assignBlocToFoyer/{idBloc}/{idFoyer}")
    public Bloc assignBlocToFoyer(@PathVariable long idBloc, @PathVariable long idFoyer) {
        return blocService.assignBlocToFoyer(idBloc, idFoyer);
    }

    @PutMapping("/unassignBlocFromFoyer/{idBloc}")
    public Bloc unassignBlocFromFoyer(@PathVariable long idBloc) {
        return blocService.unassignBlocFromFoyer(idBloc);
    }

    @GetMapping("/sansFoyer")
    public List<Bloc> getBlocsSansFoyer() {
        return blocService.getBlocsSansFoyer();
    }

    @GetMapping("/capaciteSup30")
    public List<Bloc> getBlocsCapaciteSup30() {
        return blocService.getBlocsCapaciteSup30();
    }

    @GetMapping("/nomCommencePar")
    public List<Bloc> getNomCommencePar(@RequestParam String lettre) {
        return blocService.getBlocsNomCommencePar(lettre);
    }

    @GetMapping("/nomCommenceParEtCap")
    public List<Bloc> getNomCommenceParEtCap(@RequestParam String lettre, @RequestParam int capacite) {
        return blocService.getBlocsNomCommenceParEtCapSup(lettre, capacite);
    }

}
