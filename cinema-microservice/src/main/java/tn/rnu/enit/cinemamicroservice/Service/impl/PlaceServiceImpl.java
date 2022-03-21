package tn.rnu.enit.cinemamicroservice.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rnu.enit.cinemamicroservice.Dto.PlaceDeletedDTO;
import tn.rnu.enit.cinemamicroservice.Repository.PlaceRepository;
import tn.rnu.enit.cinemamicroservice.Service.PlaceService;
import tn.rnu.enit.cinemamicroservice.domain.Place;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> getPlacesByDisponible() {
        return placeRepository.getPlacesByDisponible();
    }

    @Override
    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public PlaceDeletedDTO deletePlace(Long id) {
        Place place = placeRepository.getOne(id);
        PlaceDeletedDTO placeDeletedDTO = new PlaceDeletedDTO();
        placeDeletedDTO.setId(id);
        placeDeletedDTO.setNumeroLigne(place.getNumeroLigne());
        placeDeletedDTO.setNumeroColonne(place.getNumeroColonne());
        placeDeletedDTO.setDeleted(true);
        placeRepository.deleteById(id);
        return placeDeletedDTO;
    }
}
