package fr.youness.MSAProject.controllers;

import fr.youness.MSAProject.dao.RevenuDao;
import fr.youness.MSAProject.exceptions.RevenuNotFoundRevenuException;
import fr.youness.MSAProject.models.Revenu;
import fr.youness.MSAProject.services.IRevenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/revenusapi")
public class RevenuController {

    @Autowired
    private IRevenuService revenuService;

    @RequestMapping(value = "/revenus", method = RequestMethod.GET)
    public ResponseEntity<List<Revenu>> getRevenus() {
        List<Revenu> list = revenuService.getRevenus();
        return new ResponseEntity<List<Revenu>>(list, HttpStatus.OK);
    }

    @RequestMapping(value= "/revenu/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRevenuById(@PathVariable Long id) {
        Revenu revenu;
        if(id == 0) {
            return new ResponseEntity<String>("Private key", HttpStatus.FORBIDDEN);
        }
        revenu = revenuService.getRevenuById(id);
        if(revenu == null) {
            throw new RevenuNotFoundRevenuException("Revenu introuvable (id=" + id + ")");
        } else {
            return new ResponseEntity<Revenu>(revenu, HttpStatus.OK);
        }
    }

    @RequestMapping(value= "/revenu", method = RequestMethod.POST)
    public ResponseEntity<?> addRevenu(@RequestBody Revenu _revenu, UriComponentsBuilder builder) {
        if(revenuService.updateAndSaveRevenu(_revenu)) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/msaproject/revenu/{id}").buildAndExpand(_revenu.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Error to add new revenu", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(value="/revenu")
    public ResponseEntity<?> updateRevenu(@RequestBody Revenu _revenu, UriComponentsBuilder builder) {
        return addRevenu(_revenu, builder);
    }

    @DeleteMapping(value="/revenu/{id}")
    public ResponseEntity<?> deleteRevenu(@PathVariable Long id, UriComponentsBuilder builder) {
        if(revenuService.deleteRevenu(id)) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/msaproject/revenu/{id}").buildAndExpand(id).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
        } else {
            throw new RevenuNotFoundRevenuException("Revenu introuvable (id=" + id + ")");
        }
    }

    @GetMapping("/revenus/mois/{mois}")
    public ResponseEntity<?> getRevenuByMois(@PathVariable String mois) {
        List<Revenu> list = new ArrayList<>();
        list = revenuService.getRevenuByMois(mois);
        if (list.isEmpty()) {
            return new ResponseEntity<String>("No element founded", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Revenu>>(list, HttpStatus.FOUND);
    }
}
