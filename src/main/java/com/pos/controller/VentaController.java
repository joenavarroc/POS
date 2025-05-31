package com.pos.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.pos.interfaces.I_ClienteService;
import com.pos.interfaces.I_VentaService;
import com.pos.model.Venta;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final I_VentaService ventaService;
    private final I_ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ventas", ventaService.listarTodas());
        return "ventas/lista";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("clientes", clienteService.listarTodos());
        return "ventas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Venta venta) {
        ventaService.guardar(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        ventaService.buscarPorId(id).ifPresent(v -> model.addAttribute("venta", v));
        model.addAttribute("clientes", clienteService.listarTodos());
        return "ventas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        ventaService.eliminar(id);
        return "redirect:/ventas";
    }
}
