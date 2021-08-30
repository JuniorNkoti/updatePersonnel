/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwomiTech.updatePersonnel.web.controller;

import com.iwomiTech.updatePersonnel.dao.PersonneDao;
import com.iwomiTech.updatePersonnel.model.Personne;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author ACER
 */
@RestController
public class PersonneController {
    @Autowired
    private PersonneDao personneDao;
    
    @RequestMapping(value = "/Members/{id}", method = RequestMethod.DELETE)
    public void supprimer(@PathVariable int id){
        //Iterable<Personne> personnes = personneDao.findAll();
        personneDao.deleteById(id);
    }
    
    @RequestMapping(value = "/upPersonne", method = RequestMethod.POST)
    public String update(@RequestParam("titre") String titre,@RequestParam("id") int id){
        System.out.println("Debut d'execution");
        Personne personne = personneDao.findById(id);
    
         personne.setTitre(titre);
        personne = personneDao.save(personne);
        return personne.toString();
    
    }
   /*@RequestMapping(value = "/Members/Settings?Titre={ceTitre}&id={id} ", method = RequestMethod.POST)
    public ResponseEntity<Void> ajouterPersonne(@PathVariable String ceTitre ,@PathVariable int id) {
        System.out.println("debut execution");
        System.out.println(ceTitre);
        Personne memberToChange =  personneDao.findById(id);
        memberToChange.toString();
        memberToChange.setTitre(ceTitre); 
        Personne memberChanged = personneDao.save(memberToChange);

        if (memberChanged == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(memberChanged.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }*/
    /*@RequestMapping(value = "/Members/Settings?Titre={ceTitre}&id={id} ", method = RequestMethod.GET)
    public Personne ajouterPersonne(@PathVariable String ceTitre ,@PathVariable int id) {
        System.out.println("debut execution");
        System.out.println(ceTitre);
        Personne memberToChange =  personneDao.findById(id);
        System.out.println(memberToChange);
        memberToChange.setTitre(ceTitre);
        Personne memberChanged = personneDao.save(memberToChange);
        return memberChanged;
    }*/
}
