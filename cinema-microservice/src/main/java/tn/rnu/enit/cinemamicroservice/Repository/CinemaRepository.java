package tn.rnu.enit.cinemamicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    Cinema findCinemaByNom(String nom);
    List<Cinema> findCinemasByGouvernorat(String gouvernorat);
}
