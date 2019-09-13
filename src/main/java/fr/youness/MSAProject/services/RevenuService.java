package fr.youness.MSAProject.services;

import fr.youness.MSAProject.dao.RevenuDao;
import fr.youness.MSAProject.models.Revenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RevenuService implements IRevenuService {
    @Autowired
    RevenuDao revenuDao;

    @Override
    public List<Revenu> getRevenus() {
        List<Revenu> list = new ArrayList<>();
        revenuDao.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Revenu getRevenuById(Long id) {
        Revenu revenu = new Revenu();
        if(revenuDao.findById(id).isPresent()){
            revenu = revenuDao.findById(id).get();
        } else {
            revenu = null;
        }
        return revenu;
    }

    @Override
    public boolean updateAndSaveRevenu(Revenu revenu) {
        Revenu savedRevenu = revenuDao.save(revenu);
        if(savedRevenu == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteRevenu(Long id) {
        Revenu revenu = new Revenu();
        if(revenuDao.findById(id).isPresent()){
            revenuDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Revenu> getRevenuByMois(String mois) {
        List<Revenu> list = revenuDao.findByMois(mois);
        return list;
    }
}
