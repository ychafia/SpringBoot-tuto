package fr.youness.MSAProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Revenu {
    @Id
    @GeneratedValue
    private Long id_revenu;
    @Length(min=3, max=20)
    private String libelle_revenu;
    @JsonIgnore
    private float salaire_revenu;
    private String mois_salaire;

    public Revenu() {

    }
    public Revenu(Long id_revenu, String libelle_revenu, float salaire_revenu, String mois_salaire) {
        this.id_revenu = id_revenu;
        this.libelle_revenu = libelle_revenu;
        this.salaire_revenu = salaire_revenu;
        this.mois_salaire = mois_salaire;
    }

    public Long getId_revenu() {
        return id_revenu;
    }

    public String getLibelle_revenu() {
        return libelle_revenu;
    }

    public float getSalaire_revenu() {
        return salaire_revenu;
    }

    public String getMois_salaire() {
        return mois_salaire;
    }

    public void setId_revenu(Long id_revenu) {
        this.id_revenu = id_revenu;
    }

    public void setLibelle_revenu(String libelle_revenu) {
        this.libelle_revenu = libelle_revenu;
    }

    public void setSalaire_revenu(float salaire_revenu) {
        this.salaire_revenu = salaire_revenu;
    }

    public void setMois_salaire(String mois_salaire) {
        this.mois_salaire = mois_salaire;
    }

    @Override
    public String toString() {
        return "Revenu{" +
                "id_revenu=" + id_revenu +
                ", libelle_revenu='" + libelle_revenu + '\'' +
                ", salaire_revenu=" + salaire_revenu +
                ", mois_salaire=" + mois_salaire +
                '}';
    }
}
