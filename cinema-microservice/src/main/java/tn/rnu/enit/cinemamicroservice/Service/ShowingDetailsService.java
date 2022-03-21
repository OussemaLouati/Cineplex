package tn.rnu.enit.cinemamicroservice.Service;

import tn.rnu.enit.cinemamicroservice.Dto.ShowingDetailsDeletedDTO;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.Film;
import tn.rnu.enit.cinemamicroservice.domain.ShowingDetails;

import java.util.List;

public interface ShowingDetailsService {
    List<ShowingDetails> getAllShowingDetails();
    ShowingDetails getShowingDetailsById(Long id);
    //ShowingDetails updateShowingDetails(Long id, ShowingDetails showingDetails);
    ShowingDetails createShowingDetails(ShowingDetails showingDetails);
    ShowingDetailsDeletedDTO deleteShowingDetails(Long id);
    List<ShowingDetails> getShowingDetailsByPrixTNDBetween(double startPrixTND, double endPrixTND);
    List<ShowingDetails> findShowingDetailsByNomCinema(String nomCinema);
    List<ShowingDetails> findShowingDetailsByNomFilm(String nomFilm);
    Film getFilmInfos(ShowingDetails showingDetails);

}
