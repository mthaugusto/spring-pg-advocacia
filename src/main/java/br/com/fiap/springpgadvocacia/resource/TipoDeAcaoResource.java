package br.com.fiap.springpgadvocacia.resource;


import br.com.fiap.springpgadvocacia.entity.TipoDeAcao;

import br.com.fiap.springpgadvocacia.repository.TipoDeAcaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RequestMapping(value = "/tipodeacao")
@RestController
public class TipoDeAcaoResource {

    @Autowired
    private TipoDeAcaoRepository repository;
    @GetMapping
    public List<TipoDeAcao> findAll() {
        return repository.findAll();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoDeAcao> findById(@PathVariable(name = "id") Long id) {
        TipoDeAcao tipodeacao = repository.findById( id ).orElse( null );
        if (Objects.isNull( tipodeacao)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( tipodeacao );
    }


    @PostMapping
    @Transactional
    public ResponseEntity<TipoDeAcao> persist(@RequestBody TipoDeAcao tipoDeAcao) {
        TipoDeAcao saved = repository.save( tipoDeAcao );
        return ResponseEntity.ok( saved );
    }
}
