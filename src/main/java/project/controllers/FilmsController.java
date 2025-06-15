package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.models.Film;
import project.models.FilmsStorage;
import project.models.Genre;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class FilmsController {

    @GetMapping("/")
    public String filmsList(Model model) {
        model.addAttribute("films", FilmsStorage.getFilms());
        return "films-list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        return "create-form";
    }

    @PostMapping("/create")
    public String create(Film film) {
        film.setId(UUID.randomUUID().toString());
        FilmsStorage.getFilms().add(film);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") String id) {
        Film f = FilmsStorage.getFilms().stream()
                .filter(film -> film.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        FilmsStorage.getFilms().remove(f);
        return "redirect:/";
    }

    @GetMapping("/edit-form/{id}")
    public String editForm(@PathVariable(name = "id") String id, Model model) {
        Film filmToEdit = FilmsStorage.getFilms().stream()
                .filter(film -> film.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        model.addAttribute("film", filmToEdit);
        return "edit-form";
    }

    @PostMapping("/update")
    public String update(Film film) {
        delete(film.getId());
        FilmsStorage.getFilms().add(film);
        return "redirect:/";
    }

    @GetMapping("/filter-form")
    public String filterForm() {
        return "filter-form";
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(name = "genre") Genre genre, Model model) {

        List<Film> list = FilmsStorage.getFilms().stream()
                .filter(film -> film.getGenre().equals(genre))
                .collect(Collectors.toList());
        model.addAttribute("list", list);
        return "filter-form-genre";
    }

}
