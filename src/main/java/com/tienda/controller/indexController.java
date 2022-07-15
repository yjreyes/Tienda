
package com.tienda.controller;

// import com.tienda.dao.ClienteDao;
// import com.tienda.domain.Cliente;
import com.tienda.service.ArticuloService;
// import com.tienda.service.ClienteService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class indexController {
   
   @Autowired
    private ArticuloService articuloService; 
    
    @GetMapping("/")
    public String inicio(Model model){
        var articulos = articuloService.getArticulos(true);    
        model.addAttribute("articulos",articulos);
        return "index";
    }
    
    
    
    
    
    /*
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);    
        model.addAttribute("cliente",cliente);
        return "modificarCliente";
    }
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }*/

}
