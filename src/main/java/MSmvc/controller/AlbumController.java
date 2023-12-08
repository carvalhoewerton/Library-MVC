package MSmvc.controller;



import MSmvc.model.Album;
import MSmvc.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService service;

    @GetMapping("/albuns")
    public String allAlbuns(Model model){
        List<Album> albuns = service.getAllAlbuns();
        model.addAttribute("albuns", albuns);
        return "album-list";
    }
    @PostMapping
    public Album addAlbum(@RequestBody Album album){
        return service.save(album);
    }

    @GetMapping("/newalbum")
    public String forms(Model model){
        Album album = new Album();
        model.addAttribute("album", album);
        return "album-form";
    }
    @PostMapping("/newalbum")
    public String save(@ModelAttribute Album album){
        service.save(album);
        return "redirect:/albuns";
    }

}



