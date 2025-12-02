package tn.esprit.gestion_foyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestion_foyer.entities.Chambre;
import tn.esprit.gestion_foyer.entities.TypeChambre;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class ScheduledTasksService {

    private final IChambreService chambreService;

    // ===========================
    // 🔵 SERVICE 1
    // Liste des chambres par bloc
    // ===========================
    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    public void listeChambresParBloc() {
        List<Chambre> chambres = chambreService.findAll();

        log.info("********** Liste des chambres par bloc **********");

        chambres.forEach(ch -> {
            String bloc = (ch.getTypeBloc() != null)
                    ? ch.getTypeBloc().getNomBloc()
                    : "Aucun bloc";

            int capacite = getCapaciteByType(ch.getTypeChambre());

            log.info("Bloc {} → Chambre N°{} → capacité {}",
                    bloc, ch.getNumeroChambre(), capacite);
        });

        log.info("**************************************************");
    }

    // Méthode utilitaire interne
    private int getCapaciteByType(TypeChambre type) {
        if (type == null) return 0;
        switch (type) {
            case SIMPLE: return 1;
            case DOUBLE: return 2;
            case TRIPLE: return 3;
            default: return 0;
        }
    }


    // ===========================
    // 🔵 SERVICE 2
    // Pourcentage des types de chambres
    // ===========================
    @Scheduled(fixedDelay = 40, timeUnit = TimeUnit.SECONDS)
    public void pourcentageChambreParTypeChambre() {

        List<Chambre> chambres = chambreService.findAll();

        long total = chambres.size();
        if (total == 0) {
            log.warn("Aucune chambre trouvée.");
            return;
        }

        long simple = chambres.stream().filter(c -> c.getTypeChambre() == TypeChambre.SIMPLE).count();
        long doubleCh = chambres.stream().filter(c -> c.getTypeChambre() == TypeChambre.DOUBLE).count();
        long triple = chambres.stream().filter(c -> c.getTypeChambre() == TypeChambre.TRIPLE).count();

        log.info("********** Pourcentage des types de chambres **********");
        log.info("SIMPLE : {}%", (simple * 100) / total);
        log.info("DOUBLE : {}%", (doubleCh * 100) / total);
        log.info("TRIPLE : {}%", (triple * 100) / total);
        log.info("********************************************************");
    }


    // ===========================
    // 🔵 SERVICE 3
    // Nombre de places disponibles en 2025
    // ===========================
    @Scheduled(fixedDelay = 50, timeUnit = TimeUnit.SECONDS)
    public void nbPlacesDisponibleParChambreAnneeEnCours() {

        List<Chambre> chambres = chambreService.findAll();

        log.info("********** Nombre de places disponibles **********");

        chambres.forEach(ch -> {
            int capacite = getCapaciteByType(ch.getTypeChambre());

            int nbReservations = (ch.getTypeReservation() != null)
                    ? ch.getTypeReservation().size()
                    : 0;

            int dispo = capacite - nbReservations;

            log.info("Chambre N°{} → capacité : {} → réservations : {} → disponibles : {}",
                    ch.getNumeroChambre(),
                    capacite,
                    nbReservations,
                    dispo);
        });

        log.info("***************************************************");
    }
}
