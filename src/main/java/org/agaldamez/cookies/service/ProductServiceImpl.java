package org.agaldamez.cookies.service;

import org.agaldamez.cookies.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> listar() {
        return Arrays.asList(new Product(1L, "notebook", "tecnologia", 1700),
                new Product(2L, "laptop Asus", "tecnologia", 1200),
                new Product(3L, "mesa de escritorio", "oficina", 400));
    }

    @Override
    public Optional<Product> buscar(String name) {
        return listar().stream().filter(p -> {
            if (name == null || name.isBlank()) {
                return false;
            }
            return p.getName().contains(name);
        }).findFirst();
    }
}
