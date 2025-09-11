package com.jonatas.desafiocep.service;

import com.jonatas.desafiocep.model.Usuario;
import com.jonatas.desafiocep.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepo;

    public UsuarioDetailsService(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuário: " + username);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("Senha enviada: 123456");
        Usuario usuario = null;

        usuario = usuarioRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        System.out.println("Hash no Mongo: " + usuario.getPassword());
        System.out.println("Senha bate? " + encoder.matches("123456", usuario.getPassword()));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRole().replace("ROLE_", ""))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

    }
}