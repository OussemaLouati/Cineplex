package tn.rnu.enit.cinemamicroservice.Dto;

public class PlaceDeletedDTO {
    private Long id;
    private int numeroLigne;
    private int numeroColonne;
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroLigne() {
        return numeroLigne;
    }

    public void setNumeroLigne(int numeroLigne) {
        this.numeroLigne = numeroLigne;
    }

    public int getNumeroColonne() {
        return numeroColonne;
    }

    public void setNumeroColonne(int numeroColonne) {
        this.numeroColonne = numeroColonne;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
