package br.com.raul.aso.notepad.component;

import br.com.raul.aso.notepad.model.Igreja;
import br.com.raul.aso.notepad.repository.IgrejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IgrejaComponent {

    @Autowired
    IgrejaRepository igrejaRepository;

    public void salvar(Igreja igreja){
        List<Igreja> igrejas = igrejaRepository.findByNome(igreja.getNome());
        if(!igrejas.isEmpty()){
            igreja.setId(igrejas.get(0).getId());
        }
        igrejaRepository.save(igreja);
    }


    public Igreja buscarIgreja(String nome){
        Igreja igreja;
        List<Igreja> igrejas = igrejaRepository.findByNome(nome);
        if(igrejas.isEmpty()){
            return new Igreja();
        }else{
            return igrejas.get(0);
        }

    }


    public List<Igreja> buscarTodos(){
        return igrejaRepository.findAll();
    }

    public void apagar (String nome){
        Igreja igreja;
        List<Igreja> igrejas = igrejaRepository.findByNome(nome);
        if(!igrejas.isEmpty()){
            igrejaRepository.delete(igrejas.get(0));
        }
    }

    public void apagarTodos(){
        igrejaRepository.deleteAll();
    }
}
