package fr.youness.MSAProject.controllers;

import fr.youness.MSAProject.models.Element;
import fr.youness.MSAProject.services.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elementsapi")
public class ElementController {
    @Autowired
    private IElementService elementService;

    @GetMapping(value = "/elements")
    public ResponseEntity<List<Element>> getElement() {
        return new ResponseEntity<>(elementService.getElements(), HttpStatus.OK);
    }

    @PostMapping(value = "/element")
    public ResponseEntity<?> addElement(@RequestBody Element element) {
        return new ResponseEntity<>(elementService.updateAndSaveElement(element), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/element/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        return new ResponseEntity<>(elementService.deleteElement(id), HttpStatus.OK);
    }

}
