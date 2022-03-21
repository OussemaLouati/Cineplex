package tn.rnu.enit.cinemamicroservice.Service;

import tn.rnu.enit.cinemamicroservice.Dto.CinemaDeletedDTO;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.ShowingDetails;

import java.util.List;

public interface CinemaService {
    List<Cinema> getAllCinemas();
    Cinema getCinemaById(Long id);
    Cinema updateCinema(Long id, Cinema cinema);
    Cinema createCinema(Cinema cinema);
    CinemaDeletedDTO deleteCinema(Long id);
    Cinema getCinemaByNom(String nom);
    List<Cinema> findCinemasByGouvernorat(String gouvernorat);
}
