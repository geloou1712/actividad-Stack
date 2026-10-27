package com.example.stackspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/pila")
public class PilaController {

    private final Stack<String> teclas = new Stack<>();

    @PostMapping
    public synchronized String agregar(@RequestParam String valor) {
        teclas.push(valor);
        return "Se agregó: " + valor;
    }

    @GetMapping("/pop")
    public synchronized String sacar() {
        if (teclas.empty()) {
            return "La pila está vacía";
        }

        return "Se sacó: " + teclas.pop();
    }

    @GetMapping
    public synchronized List<String> verPila() {
        List<String> resultado = new ArrayList<>(teclas);
        Collections.reverse(resultado); // La tecla más reciente aparece primero
        return resultado;
    }
}