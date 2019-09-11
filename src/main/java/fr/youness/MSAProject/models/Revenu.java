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
    private Long id_revenu;
    @Length(min=3, max=20)
    private String libelle_revenu;
    @JsonIgnore
    private float salaire_revenu;
    private String mois_salaire;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Timestamp created;

    @LastModifiedBy
    @Column(nullable = false)
    private String modifiedBy;

    @LastModifiedDate
    @Column(nullable = false)
    private Timestamp modified;

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
                "id_revenu=" + id_revenu +
                ", libelle_revenu='" + libelle_revenu + '\'' +
                ", salaire_revenu=" + salaire_revenu +
                ", mois_salaire=" + mois_salaire +
                '}';
    }
}
