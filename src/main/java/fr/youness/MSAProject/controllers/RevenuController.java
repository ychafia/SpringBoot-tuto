package fr.youness.MSAProject.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.youness.MSAProject.dao.RevenuDao;
import fr.youness.MSAProject.exceptions.RevenuNotFoundRevenuException;
import fr.youness.MSAProject.models.Revenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/msaproject/")
public class RevenuController {
    @Autowired
    private RevenuDao revenuDao;

    @RequestMapping(value = "/revenus", method = RequestMethod.GET)
    public ResponseEntity<List<Revenu>> getRevenus() {
        List<Revenu> list = new ArrayList<>();
        revenuDao.findAll().forEach(e -> list.add(e));
        return new ResponseEntity<List<Revenu>>(list, HttpStatus.OK);
    }

    @RequestMapping(value= "/revenu/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRevenuById(@PathVariable Long id) {
        Revenu revenu;
        if(id == 0) {
            return new ResponseEntity<String>("Private key", HttpStatus.FORBIDDEN);
        }
        try {
            revenu = revenuDao.findById(id).get();
        } catch (Exception e) {
            throw new RevenuNotFoundRevenuException("Revenu introuvable (id=" + id + ")");
        }
        return new ResponseEntity<Revenu>(revenu, HttpStatus.OK);
    }

    @RequestMapping(value= "/revenu", method = RequestMethod.POST)
    public ResponseEntity<?> addRevenu(@RequestBody Revenu _revenu, UriComponentsBuilder builder) {
        revenuDao.save(_revenu);
        if(true) { //TO complete
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/msaproject/revenu/{id}").buildAndExpand(_revenu.getId_revenu()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Error to add new revenu", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(value="/revenu")
    public ResponseEntity<?> updateRevenu(@RequestBody Revenu _revenu, UriComponentsBuilder builder) {
        revenuDao.save(_revenu);
        if(true) { //To complete
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/msaproject/revenu/{id}").buildAndExpand(_revenu.getId_revenu()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Error to update revenu", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(value="/revenu/{id}")
    public ResponseEntity<?> deleteRevenu(@PathVariable Long id, UriComponentsBuilder builder) {
        Revenu revenu = revenuDao.findById(id).get();
        revenuDao.delete(revenu);
        if(true){
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/msaproject/revenu/{id}").buildAndExpand(revenu.getId_revenu()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("Error to delete revenu", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
