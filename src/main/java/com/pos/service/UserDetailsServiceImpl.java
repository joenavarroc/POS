/* package com.walletapp.service;

import com.walletapp.model.Usuario;
import com.walletapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscamos el usuario por email
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con email " + email + " no encontrado"));

        // Se construye el objeto User de Spring Security, asignando roles (si es necesario agregar roles)
        return User.builder()
                .username(usuario.getEmail())  // Usamos el email como el 'username'
                .password(usuario.getContraseña())  // Asegúrate de que la contraseña esté encriptada
                .roles("USER")  // Ejemplo: Añadir roles
                .build();
    }

    // Método para obtener un usuario por su email (solo el objeto Usuario, no UserDetails)
    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con email " + email + " no encontrado"));
    }
}
 */