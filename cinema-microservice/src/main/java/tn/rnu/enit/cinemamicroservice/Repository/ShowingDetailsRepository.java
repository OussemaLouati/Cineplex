package tn.rnu.enit.cinemamicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.rnu.enit.cinemamicroservice.domain.ShowingDetails;

import java.util.List;

public interface ShowingDetailsRepository extends JpaRepository<ShowingDetails, Long> {


    @Query("SELECT sd FROM ShowingDetails sd WHERE sd.prixTND between :startPrixTND and :endPrixTND")
    List<ShowingDetails> getShowingDetailsByPrixTNDBetween(@Param("startPrixTND") double startPrixTND, @Param("endPrixTND") double endPrixTND);

    List<ShowingDetails> findShowingDetailsByNomCinema(String nomCinema);
    List<ShowingDetails> findShowingDetailsByNomFilm(String nomFilm);
}
