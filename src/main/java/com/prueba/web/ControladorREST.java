package com.prueba.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.prueba.domain.Individuo;

import com.prueba.servicio.IndividuoServicio;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;




@Controller
@Slf4j
public class ControladorREST {

    @Autowired
    private IndividuoServicio individuoServicio;
    
    public String obtenerUsuario() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = auth.getName();
        System.out.println("El usuario que ha ingresado es: " + nombreUsuario);
        return nombreUsuario;
    }

    @GetMapping("/")
public String comienzo(Model model, @AuthenticationPrincipal User usuario) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    model.addAttribute("auth", auth);

    List<Individuo> individuos = individuoServicio.listaIndividuos();
    log.info("El usuario que ha ingresado es: " + usuario.getUsername());

    model.addAttribute("individuos", individuos);
    return "indice";
}

    @GetMapping("/agregar")
    public String agregar(Individuo individuo) {
        return "cambiar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Individuo individuo, Errors errores) {
        if (errores.hasErrors()) {
            return "cambiar";
        }
        individuoServicio.guardar(individuo);
        return "redirect:/";
    }

    @GetMapping("/cambiar/{id_individuo}")
    public String modificar(Individuo individuo, Model model) {
        individuo = individuoServicio.localizarIndividuo(individuo);
        model.addAttribute("individuo", individuo);
        return "cambiar";
    }

    @GetMapping("/eliminar/{id_individuo}")
    public String eliminar(Individuo individuo) {
        individuoServicio.eliminar(individuo);
        return "redirect:/";
    }
}
