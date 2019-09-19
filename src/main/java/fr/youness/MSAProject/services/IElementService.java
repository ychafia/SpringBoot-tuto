package fr.youness.MSAProject.services;

import fr.youness.MSAProject.models.Element;

import java.util.List;

public interface IElementService {
    List<Element> getElements();
    //public boolean makeDone(Element e);
    public boolean deleteElement(Long id);
    public boolean updateAndSaveElement(Element e);
}
