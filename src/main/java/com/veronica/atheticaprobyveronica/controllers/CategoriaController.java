package com.veronica.atheticaprobyveronica.controllers;

import com.veronica.atheticaprobyveronica.records.CategoriaRecord;
import com.veronica.atheticaprobyveronica.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("categoria", categoriaService.lista());
        return "categoria/lista";
    }

    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("categoria", new CategoriaRecord(null, null, null));
        return "categoria/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute CategoriaRecord categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categoria";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        CategoriaRecord categoria = categoriaService.obtener(id);
        model.addAttribute("categoria", categoria);
        return "categoria/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        categoriaService.eliminar(id);
        return "redirect:/categoria";
    }
}
