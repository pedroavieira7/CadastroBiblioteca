package br.com.tech4me.cadastroms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.cadastroms.model.Autores;
import br.com.tech4me.cadastroms.repository.AutoresRepository;
import br.com.tech4me.cadastroms.repository.LivrosRepository;
import br.com.tech4me.cadastroms.shared.AutoresDTO;
import java.util.Optional;

@Service
public class AutoresServiceImpl implements AutoresService{

@Autowired
private LivrosRepository repositorioLivros;
@Autowired
private AutoresRepository repositorioAutores;
    
@Override
    public Autores cadastrarAutor(AutoresDTO autorDTO) {
        
       Autores a = new Autores();
       repositorioAutores.save(a);
       return a;
    }

    @Override
    public Autores buscarAutores(String id) {
        
        Optional<Autores> autor = repositorioAutores.findById(id);
        if (autor.isPresent()){
            return autor.get();
        }

        return null;
    }
}
    

