package br.com.tech4me.cadastroms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {
    
    @PostMapping("/locacao")
public ResponseEntity<String> realizarLocacao(@RequestBody Locacao locacao) {
    
     Livro livro = livroRepository.findById(locacao.getLivroId());
     if (livro == null || livro.isLocado()) {
         return ResponseEntity.badRequest().body("Livro não disponível para locação.");
     }

 
     livro.setLocado(true);
     livroRepository.save(livro);

    
     locacaoRepository.save(locacao);

    return ResponseEntity.ok("Locação realizada com sucesso!");
}


@PostMapping("/devolucao")
public ResponseEntity<String> realizarDevolucao(@RequestBody Locacao locacao) {
    
     Locacao locacao = locacaoRepository.findById(locacao.getId());
     if (locacao == null) {
         return ResponseEntity.badRequest().body("Locação não encontrada.");
     }

  
     Livro livro = livroRepository.findById(locacao.getLivroId());
     livro.setLocado(false);
     livroRepository.save(livro);

    
     locacaoRepository.delete(locacao);

    return ResponseEntity.ok("Devolução realizada com sucesso!");
}


@GetMapping("/listagem")
public List<Locacao> listarLocacoes() {
    
     List<Locacao> locacoes = locacaoRepository.findAll();

      return locacoes;
    return null; 
}

}

