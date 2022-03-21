package tn.rnu.enit.cinemamicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rnu.enit.cinemamicroservice.domain.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
