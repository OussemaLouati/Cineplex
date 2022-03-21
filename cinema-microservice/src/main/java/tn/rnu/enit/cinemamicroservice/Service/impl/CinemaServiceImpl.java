package tn.rnu.enit.cinemamicroservice.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rnu.enit.cinemamicroservice.Dto.CinemaDeletedDTO;
import tn.rnu.enit.cinemamicroservice.Repository.CinemaRepository;
import tn.rnu.enit.cinemamicroservice.Service.CinemaService;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.ShowingDetails;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAllCinemas() { return cinemaRepository.findAll(); }

    @Override
    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findById(id).isPresent() ? cinemaRepository.findById(id).get() : null;
    }

    @Override
    public Cinema updateCinema(Long id, Cinema cinema) {
        Optional<Cinema> cinemaDb= cinemaRepository.findById(id);
        Cinema cinemaToUpdate;
        if(cinemaDb.isPresent()) {
            cinemaToUpdate = cinemaDb.get();
            cinemaToUpdate.setNom(cinema.getNom());
            cinemaToUpdate.setAdresse(cinema.getAdresse());
            cinemaToUpdate.setTelephone(cinema.getTelephone());
            cinemaToUpdate.setGouvernorat(cinema.getGouvernorat());
            cinemaToUpdate.setImage(cinema.getImage());
            cinemaToUpdate.setProgramme(cinema.getProgramme());
            return cinemaRepository.save(cinemaToUpdate);
        }
        return null;
    }

    @Override
    public Cinema createCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }


    @Override
    public CinemaDeletedDTO deleteCinema(Long id) {
        Cinema cinema = cinemaRepository.getOne(id);
        CinemaDeletedDTO cinemaDeletedDTO = new CinemaDeletedDTO();
        cinemaDeletedDTO.setId(id);
        cinemaDeletedDTO.setNom(cinema.getNom());
        cinemaDeletedDTO.setDeleted(true);
        cinemaRepository.deleteById(id);
        return cinemaDeletedDTO;
    }

    @Override
    public Cinema getCinemaByNom(String nom) { return cinemaRepository.findCinemaByNom(nom); }

    @Override
    public List<Cinema> findCinemasByGouvernorat(String gouvernorat) {
        return cinemaRepository.findCinemasByGouvernorat(gouvernorat);
    }
}
