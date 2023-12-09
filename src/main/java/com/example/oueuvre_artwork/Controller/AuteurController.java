package com.example.oueuvre_artwork.Controller;

import com.example.oueuvre_artwork.Entity.Art;
import com.example.oueuvre_artwork.Entity.Auteur;
import com.example.oueuvre_artwork.Service.ArtService;
import com.example.oueuvre_artwork.Service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/")
public class AuteurController {

    private final AuteurService auth;

    @Autowired
    public AuteurController( AuteurService auth) {
        this.auth = auth;

    }

    @PostMapping("/saveAuth")
    public String saveArt(@RequestBody Auteur aut1) {
        auth.saveAuteur(aut1);
        return "Auteur saved successfully!";
    }
    @DeleteMapping("/deleteAuth/{id}")
    public void  deleteAuteurById(@PathVariable Long id) {
        auth.deleteAuteurById(id);

    }

    @GetMapping("/getAuth/{id}")
    public ResponseEntity<Auteur> getArtById(@PathVariable Long id) {
        Auteur auth2 = auth.getAuteurById(id);
        if (auth2 != null) {
            return new ResponseEntity<>(auth2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateAut/{id}")
    public ResponseEntity<Auteur> updateArt(@PathVariable Long id, @RequestBody Auteur updatedAuth) {
        Auteur updatedEntity = auth.updateAuteur(id, updatedAuth);

        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






}
