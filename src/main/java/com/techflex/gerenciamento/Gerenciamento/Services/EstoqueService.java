package com.techflex.gerenciamento.Gerenciamento.Services;

import com.techflex.gerenciamento.Gerenciamento.Entities.EstoqueEntity;
import com.techflex.gerenciamento.Gerenciamento.Forms.EstoqueAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.EstoqueForm;
import com.techflex.gerenciamento.Gerenciamento.Repositories.EstoqueRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    //servico para criar um novo material no estoque
    public EstoqueEntity criar(EstoqueForm estoqueForm){
        return estoqueRepository.save(new EstoqueEntity(estoqueForm));
    }
    //servico para listar todos os atributos de da classe estoque
    public List<EstoqueEntity> listar(){
        return estoqueRepository.findAll();
    }

    //sevico para buscar por id
    public EstoqueEntity buscarPorId(Long id){
        return estoqueRepository.findById(id).orElse(null);
    }

    //servico para deletar um registro
    public void deletar(Long id){
        estoqueRepository.deleteById(id);
    }
    //servico para atualizar um registro
    public EstoqueEntity atualizar(Long id, EstoqueAtualizarForm estoqueForm){
        final var estoque = buscarPorId(id);
        estoque.atualizarEstoque(estoqueForm);
        return estoqueRepository.save(estoque);
    }
}
