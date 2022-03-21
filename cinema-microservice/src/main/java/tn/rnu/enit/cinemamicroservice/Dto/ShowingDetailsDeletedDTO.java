package tn.rnu.enit.cinemamicroservice.Dto;

import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.Film;

public class ShowingDetailsDeletedDTO {
    private Long id;
    private String nomCinema;
    private String nomFilm;
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCinema() {
        return nomCinema;
    }

    public void setNomCinema(String nomCinema) {
        this.nomCinema = nomCinema;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
