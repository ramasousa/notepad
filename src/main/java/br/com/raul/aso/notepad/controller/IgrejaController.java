package br.com.raul.aso.notepad.controller;

import br.com.raul.aso.notepad.component.IgrejaComponent;
import br.com.raul.aso.notepad.model.Igreja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/igreja")
public class IgrejaController {

    @Autowired
    private IgrejaComponent igrejaComponent;

    @GetMapping
    private List<Igreja> findAll() {
        return igrejaComponent.buscarTodos();
    }

    @GetMapping(value = "/nome/{nome}")
    private Igreja findAll(@PathVariable(value = "nome") String nome) {
        return igrejaComponent.buscarIgreja(nome);
    }

    @PostMapping
    private void save(@RequestBody List<Igreja> igrejas) {
        for(Igreja igreja:igrejas){
            if(igreja !=null){
                igrejaComponent.salvar(igreja);
            }
        }

    }

    @DeleteMapping
    private void deleteAll() {
        igrejaComponent.apagarTodos();
    }
}
