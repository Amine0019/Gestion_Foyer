package tn.esprit.gestion_foyer.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeChambre;


    @OneToMany(mappedBy = "chambre")
    @ToString.Exclude
    Set<Reservation> typeReservation = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    Bloc typeBloc;

}
