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
    void deleteBloc(@RequestBody long idBloc){
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
}
