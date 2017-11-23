package br.com.raul.aso.notepad.controller;

import br.com.raul.aso.notepad.component.NotaComponent;
import br.com.raul.aso.notepad.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    @Autowired
    private NotaComponent notaComponent;

    @GetMapping
    private List<Nota> findAll() {
        return notaComponent.buscarTodos();
    }

    @GetMapping(value = "/titulo/{titulo}")
    private Nota findAll(@PathVariable(value = "titulo") String titulo) {
        return notaComponent.buscarNota(titulo);
    }

    @PostMapping
    private void save(@RequestBody Nota nota) {
        notaComponent.salvar(nota);
    }

    @PostMapping
    private void saveAll(@RequestBody List<Nota> notas){
        for (Nota nota: notas)
        {
            if(nota != null){
                notaComponent.salvar(nota);
            }
        }
    }

    @DeleteMapping
    private void deleteAll() {
        notaComponent.apagarTodos();
    }
}
