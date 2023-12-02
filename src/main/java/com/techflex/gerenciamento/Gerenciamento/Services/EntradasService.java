package com.techflex.gerenciamento.Gerenciamento.Services;

import com.techflex.gerenciamento.Gerenciamento.Entities.EntradasEntity;
import com.techflex.gerenciamento.Gerenciamento.Forms.EntradasAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.EntradasForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.PedidosForm;
import com.techflex.gerenciamento.Gerenciamento.Repositories.EntradasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradasService {
    private final EntradasRepository entradasRepository;

    public EntradasService(EntradasRepository entradasRepository) {
        this.entradasRepository = entradasRepository;
    }

    public EntradasEntity criar(EntradasForm entradasForm){
        return entradasRepository.save(new EntradasEntity(entradasForm));
    }
    public List<EntradasEntity> listar(){
        return entradasRepository.findAll();
    }
    public EntradasEntity buscarPorId(Long id){
        return entradasRepository.findById(id).orElse(null);
    }
    public EntradasEntity atualizar(Long id, EntradasAtualizarForm entradasAtualizarForm){
        final var entrada = buscarPorId(id);
        entrada.atualizarEntradas(entradasAtualizarForm);
        return entradasRepository.save(entrada);
    }
}
