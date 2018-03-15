package com.zisal.security.client.two;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/13/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Controller
public class AppController {

    @Autowired
    private KeycloakRestTemplate keycloakRestTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/")
    public String displayIndex() {
        return "index";
    }

    @GetMapping("/products")
    public String displayProducts(Model p_Model, Principal p_Principal) {
        p_Model.addAttribute("userName", p_Principal.getName());
        p_Model.addAttribute("products", Arrays.asList("iPhone", "iPad", "iPod"));
        return "products";
    }

    @GetMapping("/productFromRest")
    public String getProductFromRest(Model p_Model, Principal p_Principal) {
        ResponseEntity<String[]> products = keycloakRestTemplate.getForEntity("http://localhost:8083/rest-app/products", String[].class);
        p_Model.addAttribute("products", products.getBody());
        p_Model.addAttribute("userName", p_Principal.getName());
        return "products-rest";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest p_HttpServletRequest) throws ServletException {
        p_HttpServletRequest.logout();
        return "redirect:/";
    }
}
