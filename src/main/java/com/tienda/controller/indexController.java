
package com.tienda.controller;

import com.tienda.dao.ClienteDao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j

public class indexController {
    @Autowired
    private ClienteDao clienteDao;
    @GetMapping("/")
    public String inicio(Model model){
        log.info("ahora se usa arquitectura MVC");
        
        var clientes = clienteDao.findALL();
        
        model.addAttribute("clientes",clientes);
        return "index";
    }


}
