package fr.youness.MSAProject.dao;

import fr.youness.MSAProject.models.Revenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RevenuDao extends CrudRepository<Revenu, Long> {
    /*public List<Revenu> findAll();

    public Revenu revenufindById(int id);

    public boolean revenuSave(Revenu revenu);*/
}
