package com.techflex.gerenciamento.Gerenciamento.Services;

import com.techflex.gerenciamento.Gerenciamento.Entities.ProducaoEntity;
import com.techflex.gerenciamento.Gerenciamento.Forms.ProducaoAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.ProducaoForm;
import com.techflex.gerenciamento.Gerenciamento.Repositories.ProducaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;

@Service
public class ProducaoService {

    private final ProducaoRepository producaoRepository;

    public ProducaoService(ProducaoRepository producaoRepository) {
        this.producaoRepository = producaoRepository;
    }

    public ProducaoEntity criar(ProducaoForm producaoForm){
        return producaoRepository.save(new ProducaoEntity(producaoForm));
    }

    public List<ProducaoEntity> listar(){
        return producaoRepository.findAll();
    }

    public ProducaoEntity buscarPorId(Long id){
       return producaoRepository.findById(id).orElse(null);
    }
    public ProducaoEntity atualizar(Long id, ProducaoAtualizarForm producaoAtualizarForm){
        final var producao = buscarPorId(id);
        producao.atualizarProducao(producaoAtualizarForm);
        return producaoRepository.save(producao);
    }

}
