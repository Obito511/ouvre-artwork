package com.example.oueuvre_artwork.Controller;

import com.example.oueuvre_artwork.Entity.Art;
import com.example.oueuvre_artwork.Service.ArtService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/")
public class ArtController {
    private final ArtService art;

    @Autowired
    public ArtController(ArtService art) {
        this.art = art;
    }

    @PostMapping("/save")
    public String saveArt(@RequestBody Art art1) {
        art.saveArt(art1);
        return "Art saved successfully!";
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteArtById(@PathVariable Long id) {
        art.deleteArtById(id);

    }

    @GetMapping("/getArt/{id}")
    public ResponseEntity<Art> getArtById(@PathVariable Long id) {
        Art art2 = art.getArtById(id);
        if (art2 != null) {
            return new ResponseEntity<>(art2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Art> updateArt(@PathVariable Long id, @RequestBody Art updatedArt) {
        Art updatedEntity = art.updateArt(id, updatedArt);

        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
