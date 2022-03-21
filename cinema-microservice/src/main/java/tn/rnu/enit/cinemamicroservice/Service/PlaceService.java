package tn.rnu.enit.cinemamicroservice.Service;

import tn.rnu.enit.cinemamicroservice.Dto.PlaceDeletedDTO;
import tn.rnu.enit.cinemamicroservice.domain.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getPlacesByDisponible();
    Place createPlace(Place place);
    PlaceDeletedDTO deletePlace(Long id);
}
