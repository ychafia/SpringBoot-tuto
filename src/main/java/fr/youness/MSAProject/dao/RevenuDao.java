package fr.youness.MSAProject.dao;

import fr.youness.MSAProject.models.Revenu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RevenuDao extends CrudRepository<Revenu, Long> {
    List<Revenu> findByMois(String mois);
}
