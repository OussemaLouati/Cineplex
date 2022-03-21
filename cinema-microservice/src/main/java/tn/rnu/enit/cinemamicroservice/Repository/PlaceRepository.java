package tn.rnu.enit.cinemamicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.rnu.enit.cinemamicroservice.domain.Place;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query(value = "SELECT pl FROM Place pl WHERE pl.disponible = true", nativeQuery = true)
    List<Place> getPlacesByDisponible();
}
