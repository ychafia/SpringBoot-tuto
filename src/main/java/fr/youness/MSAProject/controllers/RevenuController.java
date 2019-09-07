package fr.youness.MSAProject.controllers;

import fr.youness.MSAProject.dao.RevenuDao;
import fr.youness.MSAProject.models.Revenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/msaproject/")
public class RevenuController {
    @Autowired
    private RevenuDao revenuDao;

    @RequestMapping(value = "/revenus", method = RequestMethod.GET)
    public List<Revenu> getRevenus() {
        return revenuDao.findAll();
    }

    /*@RequestMapping(value = "/revenus", method = RequestMethod.GET)
    public MappingJacksonValue getRevenus() {
        Iterable<Revenu> revenus = revenuDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(revenus);

        produitsFiltres.setFilters(listDeNosFiltres);

        return produitsFiltres;
    }*/

    @RequestMapping(value= "/revenu/{id}", method = RequestMethod.GET)
    public Optional<Revenu> getRevenu(@PathVariable Long id) {
        return revenuDao.findById(id);
    }

    @RequestMapping(value= "/revenu", method = RequestMethod.POST)
    public void addRevenu(@RequestBody Revenu _revenu) {
        revenuDao.save(_revenu);
    }
}
