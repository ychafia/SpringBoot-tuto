package fr.youness.MSAProject.services;

import fr.youness.MSAProject.models.Element;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IElementService {
    List<Element> getElements();
    //public boolean makeDone(Element e);
    public boolean deleteElement(Long id);
    public Element updateAndSaveElement(Element e);
//    @Query("Select")
//    public Long makeDone(Long id);
}
