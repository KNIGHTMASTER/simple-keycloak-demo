package com.zisal.security.restapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/14/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class ProductService {

    @GetMapping("/products")
    public List<String> getProducts() {
        return Arrays.asList("iPhone", "iPad", "iPod");
    }
}
