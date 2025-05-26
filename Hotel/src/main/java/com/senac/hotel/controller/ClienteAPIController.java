
package com.senac.hotel.controller;

import com.senac.hotel.model.Cliente;
import com.senac.hotel.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins= "*")
public class ClienteAPIController {
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public List<Cliente> listarTodos(){
        return clienteService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable int id){
        return clienteService.buscarPorId(id);
    }
    
    @PostMapping
    public Cliente criarcliente(@RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }
    
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable int id, @RequestBody Cliente clienteAtualizado){
        return clienteService.salvar(clienteAtualizado);
       
    }
    
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable int id){
        clienteService.excluir(id);
    }
    
}
