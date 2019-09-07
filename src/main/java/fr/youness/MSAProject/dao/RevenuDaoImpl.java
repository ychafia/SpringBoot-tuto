package fr.youness.MSAProject.dao;

import fr.youness.MSAProject.models.Revenu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RevenuDaoImpl implements RevenuDao {
    public static List<Revenu> revenus = new ArrayList<>();
    static {
        revenus.add(new Revenu(new Long(1), "Salaire 1", 100, "Janv-18"));
        revenus.add(new Revenu(new Long(2), "Salaire 2", 200, "Janv-18"));
        revenus.add(new Revenu(new Long(3), "Salaire 3", 300, "Janv-18"));
    }
    @Override
    public List<Revenu> findAll() {
        return revenus;
    }

    @Override
    public Revenu RevenufindById(int id) {
        for(Revenu rev : revenus){
            if(rev.getId_revenu() == id){
                return rev;
            }
        }
        return null;
    }

    @Override
    public void Revenusave(Revenu revenu) {
        revenus.add(revenu);
    }
}
