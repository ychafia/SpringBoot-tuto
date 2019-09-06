package fr.youness.MSAProject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/msaproject/")
public class RevenuController {
    @RequestMapping(value = "/revenu", method = RequestMethod.GET)
    public ArrayList<String> getRevenus(){
        ArrayList<String> revenus = new ArrayList<String>();
        revenus.add("1000");
        revenus.add("2000");
        return revenus;
    }
}
