package com.techflex.gerenciamento.Gerenciamento.Controllers;

import com.techflex.gerenciamento.Gerenciamento.Dtos.DetalhamentoEntradasDTO;
import com.techflex.gerenciamento.Gerenciamento.Dtos.EntradasDTO;
import com.techflex.gerenciamento.Gerenciamento.Entities.EntradasEntity;
import com.techflex.gerenciamento.Gerenciamento.Forms.EntradasAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.EntradasForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.EstoqueAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Services.EntradasService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradasController {

    private final EntradasService entradasService;

    public EntradasController(EntradasService entradasService) {
        this.entradasService = entradasService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoEntradasDTO> criar(@RequestBody @Valid EntradasForm entradasForm, UriComponentsBuilder uriBuilder){
        final var entrada = entradasService.criar(entradasForm);
        final var uri = uriBuilder.path("/{id}").buildAndExpand(entrada.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoEntradasDTO(entrada));
    }
    @GetMapping
    public ResponseEntity<List<EntradasDTO>> listar(){
        return ResponseEntity.ok(entradasService.listar().stream().map(EntradasDTO::new).toList());
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EntradasDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EntradasAtualizarForm entradasAtualizarForm){
        final var entrada = entradasService.atualizar(id, entradasAtualizarForm);
        return ResponseEntity.ok(new EntradasDTO(entrada));
    }
}
