
package com.senac.hotel.service;

import com.senac.hotel.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senac.hotel.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    
    public Cliente buscarPorId(int id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
    public void excluir(int id) {
        clienteRepository.deleteById(id);
    }
    
    
}
