package fr.youness.MSAProject.services;

import fr.youness.MSAProject.dao.ElementDao;
import fr.youness.MSAProject.models.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementService implements IElementService {
    @Autowired
    private ElementDao elementDao;

    @Override
    public List<Element> getElements() {
        List<Element> list = new ArrayList<>();
        elementDao.findAll().forEach(e -> list.add(e) );
        return list;
    }

    @Override
    public boolean deleteElement(Long id) {
        if(elementDao.findById(id).isPresent()) {
            elementDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Element updateAndSaveElement(Element e) {
        return elementDao.save(e);
    }
}
