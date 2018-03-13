package com.zisal.security.client.one;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created on 3/13/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Controller
public class AppController {

    @GetMapping("/")
    public String displayIndex() {
        return "index";
    }

    @GetMapping("/products")
    public String displayProducts(Model p_Model) {
        p_Model.addAttribute("products", Arrays.asList("iPhone", "iPad", "iPod"));
        return "products";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest p_HttpServletRequest) throws ServletException {
        p_HttpServletRequest.logout();
        return "redirect:/";
    }
}
