
package com.senac.hotel.controller;

import com.senac.hotel.model.Analise;
import com.senac.hotel.model.Cliente;
import com.senac.hotel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/analise")
public class AnaliseController {
    
    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/gravar/{clienteId}")
    public String adicionarAnalise(@PathVariable int clienteId, @ModelAttribute Analise novoAnalise){
        Cliente cliente = clienteService.buscarPorId(clienteId);
        if (cliente != null){
            cliente.adicionarAnalise(novoAnalise);
        }
        return "redirect:/cliente/detalhes/" + clienteId;
        
    }
}
