package fr.youness.MSAProject.services;

import fr.youness.MSAProject.models.Revenu;

import java.util.List;

public interface IRevenuService {
    List<Revenu> getRevenus();
    Revenu getRevenuById(Long id);
    boolean updateAndSaveRevenu(Revenu revenu);
    boolean deleteRevenu(Long id);
    List<Revenu> getRevenuByMois(String mois);
}
