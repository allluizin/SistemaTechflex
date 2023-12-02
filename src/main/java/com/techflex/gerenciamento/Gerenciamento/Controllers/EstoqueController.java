package com.techflex.gerenciamento.Gerenciamento.Controllers;

import com.techflex.gerenciamento.Gerenciamento.Dtos.DetalhamentoEstoqueDTO;
import com.techflex.gerenciamento.Gerenciamento.Dtos.EstoqueDTO;
import com.techflex.gerenciamento.Gerenciamento.Forms.EstoqueAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.EstoqueForm;
import com.techflex.gerenciamento.Gerenciamento.Services.EstoqueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoEstoqueDTO> criar(@RequestBody @Valid EstoqueForm estoqueForm, UriComponentsBuilder uriBuilder){
        final var estoque = estoqueService.criar(estoqueForm);
        final var uri = uriBuilder.path("/estoque/{id}").buildAndExpand(estoque.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoEstoqueDTO(estoque));
    }

    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> listar(){
        return ResponseEntity.ok(estoqueService.listar().stream().map(EstoqueDTO::new).toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        var estoqueId = estoqueService.buscarPorId(id);
        if(estoqueId != null) {
            return ResponseEntity.ok(new DetalhamentoEstoqueDTO(estoqueId));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao encontrado");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstoqueDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EstoqueAtualizarForm estoqueAtualizarForm){
        final var estoque = estoqueService.atualizar(id, estoqueAtualizarForm);
        return ResponseEntity.ok(new EstoqueDTO(estoque));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity apagarRegistro(@PathVariable Long id){
        estoqueService.deletar(id);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
}
