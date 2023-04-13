package sptech.school.projetobuscadoresdinamicos.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.projetobuscadoresdinamicos.entities.Diretor;
import sptech.school.projetobuscadoresdinamicos.repository.DiretorRepository;

import java.util.List;

@Tag(name = "Filmes", description = "Gerenciador de requisições")
@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorRepository diretorRepository;

    @PostMapping
    public ResponseEntity<Diretor> cadastrar(@RequestBody Diretor diretor) {
        Diretor diretorRegistrado = this.diretorRepository.save(diretor);
        return ResponseEntity.status(201).body(diretorRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> listar() {

        List<Diretor> diretores = this.diretorRepository.findAll();

        if (diretores.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(diretores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretor> buscarPorId(@PathVariable long id) {
        return ResponseEntity.of(this.diretorRepository.findById(id));
    }


}
