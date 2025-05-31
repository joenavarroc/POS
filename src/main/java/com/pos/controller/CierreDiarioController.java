package com.pos.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pos.interfaces.I_CierreDiarioService;
import com.pos.model.CierreDiario;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cierres")
@RequiredArgsConstructor
public class CierreDiarioController {

    private final I_CierreDiarioService cierreService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cierres", cierreService.listarTodos());
        return "cierres/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("cierre", new CierreDiario());
        return "cierres/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute CierreDiario cierre) {
        cierreService.guardar(cierre);
        return "redirect:/cierres";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        cierreService.buscarPorId(id).ifPresent(c -> model.addAttribute("cierre", c));
        return "cierres/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        cierreService.eliminar(id);
        return "redirect:/cierres";
    }
}

