package org.agaldamez.cookies.service;

import org.agaldamez.cookies.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> listar();

    Optional<Product> buscar(String name);
}
