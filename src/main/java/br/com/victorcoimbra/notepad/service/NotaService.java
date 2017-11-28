package br.com.victorcoimbra.notepad.service;


import br.com.victorcoimbra.notepad.model.Nota;
import br.com.victorcoimbra.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota){
        Nota aux = notaRepository.findByTitulo(nota.getTitulo());
        if(aux != null){
            nota.setId(aux.getId());
        }
        notaRepository.save(nota);
    }

    public List<Nota> buscarTodas(){
        return notaRepository.findAll();
    }

    public Nota buscar(String titulo){
        Nota aux = notaRepository.findByTitulo(titulo);
        if(aux == null) {
            return  new Nota();
        } else{
            return notaRepository.findByTitulo(titulo);
        }
    }
}
