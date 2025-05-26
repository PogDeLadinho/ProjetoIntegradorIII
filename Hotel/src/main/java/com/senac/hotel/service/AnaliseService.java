
package com.senac.hotel.service;

import com.senac.hotel.model.Analise;
import com.senac.hotel.repository.AnaliseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {
    @Autowired
    private AnaliseRepository analiseRepository;

    
    public List<Analise> listarPorCliente(int clienteId){
        return analiseRepository.findByClienteId(clienteId);  
    }
    
    public Analise salvar(Analise analise){
        return analiseRepository.save(analise);
    }
    
    public void excluir(int id){
        analiseRepository.deleteById(id);
    }
    
    public Analise buscarPorId(int id){
        return analiseRepository.findById(id).orElse(null);
    }
    
    
}
