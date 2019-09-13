package fr.youness.MSAProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Revenu {
    @Id
    @GeneratedValue
    private Long id;

    @Length(min=3, max=20)
    private String libelle;

    private float salaire;

    private String mois;

    @JsonIgnore
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Timestamp created;

    @JsonIgnore
    @LastModifiedBy
    @Column(nullable = false)
    private String modifiedBy;

    @JsonIgnore
    @LastModifiedDate
    @Column(nullable = false)
    private Timestamp modified;

    public Revenu() {}

    public Revenu(Long id, @Length(min = 3, max = 20) String libelle, float salaire, String mois) {
        this.id = id;
        this.libelle = libelle;
        this.salaire = salaire;
        this.mois = mois;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getSalaire() {
        return this.salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getMois() {
        return this.mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Revenu{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", salaire=" + salaire +
                ", mois=" + mois +
                '}';
    }
}
