package com.techflex.gerenciamento.Gerenciamento.Controllers;

import com.techflex.gerenciamento.Gerenciamento.Dtos.DetalhamentoProducaoDTO;
import com.techflex.gerenciamento.Gerenciamento.Dtos.PedidoDTO;
import com.techflex.gerenciamento.Gerenciamento.Dtos.ProducaoDTO;
import com.techflex.gerenciamento.Gerenciamento.Forms.ProducaoAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.ProducaoForm;
import com.techflex.gerenciamento.Gerenciamento.Services.ProducaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/producao")
public class ProducaoController {

    private final ProducaoService producaoService;

    public ProducaoController(ProducaoService producaoService) {
        this.producaoService = producaoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoProducaoDTO> criar(@RequestBody @Valid ProducaoForm producaoForm, UriComponentsBuilder uriBuilder){
        final var producao = producaoService.criar(producaoForm);
        final var uri = uriBuilder.path("/{id}").buildAndExpand(producao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoProducaoDTO(producao));
    }
    @GetMapping
    public ResponseEntity<List<ProducaoDTO>> listar(){
        return ResponseEntity.ok(producaoService.listar().stream().map(ProducaoDTO::new).toList());
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProducaoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProducaoAtualizarForm producaoAtualizarForm){
        final var producao = producaoService.atualizar(id, producaoAtualizarForm);
        return ResponseEntity.ok(new ProducaoDTO(producao));
    }
}
