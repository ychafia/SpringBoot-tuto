package fr.youness.MSAProject.controllers;

import fr.youness.MSAProject.dao.RevenuDao;
import fr.youness.MSAProject.models.Revenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/msaproject/")
public class RevenuController {
    @Autowired
    private RevenuDao revenuDao;

    @RequestMapping(value = "/revenus", method = RequestMethod.GET)
    public List<Revenu> getRevenus(){
        return revenuDao.findAll();
    }
}
