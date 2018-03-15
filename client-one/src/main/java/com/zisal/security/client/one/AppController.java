package com.zisal.security.client.one;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;

/**
 * Created on 3/13/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Controller
public class AppController {

    @Autowired
    private KeycloakSecurityContext securityContext;

    @Autowired
    private AccessToken accessToken;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/")
    public String displayIndex() {
        return "index";
    }

    @GetMapping("/products")
    public String displayProducts(Model p_Model, Principal p_Principal) {
        p_Model.addAttribute("products", Arrays.asList("iPhone", "iPad", "iPod"));
        p_Model.addAttribute("userName", p_Principal.getName());
        LOGGER.info("Access Token : "+securityContext.getTokenString());
        LOGGER.info("User : "+accessToken.getPreferredUsername()+"/"+accessToken.getName());
        LOGGER.info("Principal : "+p_Principal.getName());
        return "products";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest p_HttpServletRequest) throws ServletException {
        p_HttpServletRequest.logout();
        LOGGER.info("Logged Out From KeyCloak");
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String displayAdmin(Model p_Model, Principal p_Principal) {
        p_Model.addAttribute("accessToken", securityContext.getTokenString());
        p_Model.addAttribute("user", accessToken.getPreferredUsername()+"/"+accessToken.getName());
        p_Model.addAttribute("principal", p_Principal.toString());
        return "admin";
    }
}
