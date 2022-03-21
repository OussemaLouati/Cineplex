package tn.rnu.enit.cinemamicroservice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String adresse;
    private String telephone;
    private String gouvernorat;
    private String image;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShowingDetails> programme;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cinema")
    private List<Review> reviews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ShowingDetails> getProgramme() {
        return programme;
    }

    public void setProgramme(List<ShowingDetails> programme) {
        this.programme = programme;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addShowingDetail(ShowingDetails showingDetails){
        this.programme.add(showingDetails);
    }
}
