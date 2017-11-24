package br.com.raul.aso.notepad.repository;

import br.com.raul.aso.notepad.model.Igreja;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IgrejaRepository extends MongoRepository <Igreja, String>{
    List<Igreja> findByNome(String nome);
}
