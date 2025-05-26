
package com.senac.hotel.controller;

import com.senac.hotel.model.Cliente;
import com.senac.hotel.service.AnaliseService;
import com.senac.hotel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private AnaliseService analiseService;
    
    @GetMapping("/cadastro")
    public String exibirFormulario(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        model.addAttribute("css", tema);
        model.addAttribute("cliente", new Cliente());
        return "cliente-cadastro";
    }
    
    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/cliente/lista";
    }
    
    @GetMapping("/lista")
    public String lista(@CookieValue(name = "pref-estilo", defaultValue="claro") String tema, Model model){
        model.addAttribute("css", tema);
        model.addAttribute("clientes", clienteService.listarTodos());
        return "cliente-listagem";
    }
    
    
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable int id, Model model){
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        return "clientecadastro";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
    clienteService.excluir(id);
    return "redirect:/cliente/lista";
}
    
    @GetMapping("/detalhes/{id}")
    public String exibirDetalhes(@PathVariable int id, Model model){
    Cliente cliente = clienteService.buscarPorId(id);
    
    model.addAttribute("cliente", cliente);
    model.addAttribute("analises", analiseService.listarPorCliente(id));
    return "detalhes";
    }
        
    
    
}
