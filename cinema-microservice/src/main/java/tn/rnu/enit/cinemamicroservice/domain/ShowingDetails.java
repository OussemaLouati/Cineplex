package tn.rnu.enit.cinemamicroservice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShowingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomCinema;

    private String nomFilm;

    private String temps;
    private double prixTND;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Place> places;

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

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public double getPrixTND() {
        return prixTND;
    }

    public void setPrixTND(double prixTND) {
        this.prixTND = prixTND;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
