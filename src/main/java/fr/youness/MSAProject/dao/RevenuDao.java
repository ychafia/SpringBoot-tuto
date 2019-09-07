package fr.youness.MSAProject.dao;

import fr.youness.MSAProject.models.Revenu;

import java.util.List;

public interface RevenuDao {
    public List<Revenu> findAll();

    public Revenu RevenufindById(int id);

    public void Revenusave(Revenu revenu);
}
