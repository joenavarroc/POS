package com.pos.controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pos.interfaces.I_DetalleVentaService;
import com.pos.interfaces.I_ProductoService;
import com.pos.interfaces.I_VentaService;
import com.pos.model.DetalleVenta;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/detalles")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final I_DetalleVentaService detalleService;
    private final I_VentaService ventaService;
    private final I_ProductoService productoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("detalles", detalleService.listarTodos());
        return "detalles/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("detalleVenta", new DetalleVenta());
        model.addAttribute("ventas", ventaService.listarTodas());
        model.addAttribute("productos", productoService.listarTodos());
        return "detalles/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute DetalleVenta detalle) {
        detalleService.guardar(detalle);
        return "redirect:/detalles";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        detalleService.buscarPorId(id).ifPresent(d -> model.addAttribute("detalleVenta", d));
        model.addAttribute("ventas", ventaService.listarTodas());
        model.addAttribute("productos", productoService.listarTodos());
        return "detalles/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        detalleService.eliminar(id);
        return "redirect:/detalles";
    }
}

