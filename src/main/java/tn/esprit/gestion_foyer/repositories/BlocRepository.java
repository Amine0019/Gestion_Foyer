package tn.esprit.gestion_foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestion_foyer.entities.Bloc;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    // 3. Blocs non affectés à un foyer
    List<Bloc> findByFoyerIsNull();

    // 4. Blocs avec capacité > 30
    List<Bloc> findByCapaciteBlocGreaterThan(int capacite);

    // 5. Blocs avec nom qui commence par A
    List<Bloc> findByNomBlocStartingWith(String prefix);

    // 6. Nom commence par A ET capacité > 30
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String prefix, int capacite);
}
