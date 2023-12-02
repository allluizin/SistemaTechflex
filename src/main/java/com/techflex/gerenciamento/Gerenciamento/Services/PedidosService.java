package com.techflex.gerenciamento.Gerenciamento.Services;

import com.techflex.gerenciamento.Gerenciamento.Entities.PedidosEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.EstadoEnum;
import com.techflex.gerenciamento.Gerenciamento.Forms.PedidosAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.PedidosForm;
import com.techflex.gerenciamento.Gerenciamento.Repositories.PedidosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {

    private final PedidosRepository pedidosRepository;

    public PedidosService(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    public PedidosEntity criar(PedidosForm pedidosForm){
        return pedidosRepository.save(new PedidosEntity(pedidosForm));
    }

    public List<PedidosEntity> listar(){
        return pedidosRepository.findAll().stream().sorted((item1, item2)->{
            if(item2.getEstadoEnum() == EstadoEnum.ENTREGUE){
                return -1;
            }
            return item1.getEstadoEnum().compareTo(item2.getEstadoEnum());
        }).toList();
    }
    public PedidosEntity buscarPorId(Long id){
        return pedidosRepository.findById(id).orElse(null);
    }
    public PedidosEntity atualizar(Long id, PedidosAtualizarForm pedidosAtualizarForm){
        final var pedido = buscarPorId(id);
        pedido.atualizarPedidos(pedidosAtualizarForm);
        return pedidosRepository.save(pedido);
    }
    public void deletar(Long id){
        pedidosRepository.deleteById(id);
    }
}
