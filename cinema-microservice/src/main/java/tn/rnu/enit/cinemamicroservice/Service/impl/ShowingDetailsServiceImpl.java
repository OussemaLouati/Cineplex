package tn.rnu.enit.cinemamicroservice.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.rnu.enit.cinemamicroservice.Dto.ShowingDetailsDeletedDTO;
import tn.rnu.enit.cinemamicroservice.Repository.CinemaRepository;
import tn.rnu.enit.cinemamicroservice.Repository.ShowingDetailsRepository;
import tn.rnu.enit.cinemamicroservice.Service.ShowingDetailsService;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.Film;
import tn.rnu.enit.cinemamicroservice.domain.ShowingDetails;

import java.util.List;
import java.util.Optional;

@Service
public class ShowingDetailsServiceImpl implements ShowingDetailsService {

    @Autowired
    private ShowingDetailsRepository showingDetailsRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ShowingDetails> getAllShowingDetails() {
        return showingDetailsRepository.findAll();
    }

    @Override
    public ShowingDetails getShowingDetailsById(Long id) {
        return showingDetailsRepository.findById(id).isPresent() ? showingDetailsRepository.findById(id).get() : null;
    }

    /*@Override
    public ShowingDetails updateShowingDetails(Long id, ShowingDetails showingDetails) {
        Optional<ShowingDetails> showingDetailsDb= showingDetailsRepository.findById(id);
        ShowingDetails showingDetailsToUpdate;
        if(showingDetailsDb.isPresent()) {
            showingDetailsToUpdate = showingDetailsDb.get();
            showingDetailsToUpdate.setFilm(showingDetails.getFilm());
            showingDetailsToUpdate.setTemps(showingDetails.getTemps());
            showingDetailsToUpdate.setPrixTND(showingDetails.getPrixTND());
            showingDetailsToUpdate.setPlaces(showingDetails.getPlaces());
            return showingDetailsRepository.save(showingDetailsToUpdate);
        }
        return null;
    }*/

    @Override
    public ShowingDetails createShowingDetails(ShowingDetails showingDetails) {
        if(restTemplate.getForObject("http://localhost:8082/api/find-film-titre/"+showingDetails.getNomFilm(), Film.class) != null)
        {
            cinemaRepository.findCinemaByNom(showingDetails.getNomCinema()).addShowingDetail(showingDetails);
            return showingDetailsRepository.save(showingDetails);
        }
        return null;
    }

    @Override
    public ShowingDetailsDeletedDTO deleteShowingDetails(Long id){
        ShowingDetails showingDetails = showingDetailsRepository.getOne(id);
        ShowingDetailsDeletedDTO showingDetailsDeletedDTO = new ShowingDetailsDeletedDTO();
        showingDetailsDeletedDTO.setId(id);
        showingDetailsDeletedDTO.setNomCinema(showingDetails.getNomCinema());
        showingDetailsDeletedDTO.setNomFilm(showingDetails.getNomFilm());
        showingDetailsDeletedDTO.setDeleted(true);
        showingDetailsRepository.deleteById(id);
        return showingDetailsDeletedDTO;
    }

    @Override
    public List<ShowingDetails> getShowingDetailsByPrixTNDBetween(double startPrixTND, double endPrixTND) {
        return showingDetailsRepository.getShowingDetailsByPrixTNDBetween(startPrixTND,endPrixTND);
    }

    @Override
    public List<ShowingDetails> findShowingDetailsByNomCinema(String nomCinema) {
        return showingDetailsRepository.findShowingDetailsByNomCinema(nomCinema);
    }

    @Override
    public List<ShowingDetails> findShowingDetailsByNomFilm(String nomFilm) {
        return showingDetailsRepository.findShowingDetailsByNomFilm(nomFilm);
    }

    @Override
    public Film getFilmInfos(ShowingDetails showingDetails){
        return restTemplate.getForObject("http://localhost:8082/api/find-film-titre"+showingDetails.getNomFilm(), Film.class);
    }
}
