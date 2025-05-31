package com.pos.controller;

import com.pos.auth.AuthResponse;
import com.pos.auth.LoginRequest;
import com.pos.auth.RegisterRequest;
import com.pos.model.Negocio;
import com.pos.service.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Vistas HTML
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";  // login.html
    }

    @PostMapping("/login")
    public String loginDesdeFormulario(@ModelAttribute LoginRequest loginRequest, Model model, HttpServletResponse response) {
        try {
            AuthResponse authResponse = authService.login(loginRequest);
            String token = authResponse.getToken();

            Cookie cookie = new Cookie("jwt", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            return "redirect:/panel"; // redirige al panel principal del POS
        } catch (BadCredentialsException e) {
            model.addAttribute("errorLogin", "Credenciales incorrectas");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "Error en el proceso de login");
            return "login";
        }
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> loginDesdeAPI(@RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse response = authService.login(loginRequest);
            return ResponseEntity.ok().body(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al generar token");
        }
    }

    @GetMapping("/register")
    public String mostrarRegistro() {
        return "register"; // register.html
    }

@PostMapping("/register")
public String registrarUsuarioDesdeFormulario(@RequestParam("username") String username,
                                              @RequestParam("nombre") String nombre,
                                              @RequestParam("email") String email,
                                              @RequestParam("password") String password,
                                              @RequestParam("negocio") String nombreNegocio, // asumimos que es el nombre del negocio
                                              Model model) {
    try {
        RegisterRequest request = new RegisterRequest();
        request.setUsername(username);
        request.setNombre(nombre);
        request.setEmail(email);
        request.setPassword(password);

        // Creamos una instancia de Negocio con el nombre
        Negocio negocio = new Negocio();
        negocio.setNombre(nombreNegocio); // suponiendo que solo seteás el nombre

        request.setNegocio(negocio);

        authService.register(request);

        return "redirect:/auth/login";
    } catch (Exception e) {
        model.addAttribute("errorRegistro", "Error al registrar el usuario: " + e.getMessage());
        return "register";
    }
}

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> registrarUsuarioDesdeAPI(@RequestBody RegisterRequest registerRequest) {
        try {
            String result = authService.register(registerRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en el registro");
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // Borra cookie
        response.addCookie(cookie);
        return "redirect:/auth/login";
    }
}
