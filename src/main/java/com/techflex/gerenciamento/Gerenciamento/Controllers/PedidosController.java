package com.techflex.gerenciamento.Gerenciamento.Controllers;

import com.techflex.gerenciamento.Gerenciamento.Dtos.DetalhamentoEstoqueDTO;
import com.techflex.gerenciamento.Gerenciamento.Dtos.DetalhamentoPedidosDTO;
import com.techflex.gerenciamento.Gerenciamento.Dtos.PedidoDTO;
import com.techflex.gerenciamento.Gerenciamento.Forms.PedidosAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.PedidosForm;
import com.techflex.gerenciamento.Gerenciamento.Services.PedidosService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidosService pedidosService;

    public PedidosController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoPedidosDTO> criar(@RequestBody @Valid PedidosForm pedidosForm, UriComponentsBuilder uriBuilder){
        final var pedido = pedidosService.criar(pedidosForm);
        final var uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoPedidosDTO(pedido));
    }
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listar(){
        return ResponseEntity.ok(pedidosService.listar().stream().map(PedidoDTO::new).toList());
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDTO> atualizarPedido(@PathVariable Long id, @RequestBody @Valid PedidosAtualizarForm pedidosAtualizarForm){
        final var pedido = pedidosService.atualizar(id, pedidosAtualizarForm);
        return ResponseEntity.ok(new PedidoDTO(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagarRegistro(@PathVariable Long id){
        pedidosService.deletar(id);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }
}
