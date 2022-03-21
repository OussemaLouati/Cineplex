package tn.rnu.enit.cinemamicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rnu.enit.cinemamicroservice.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
