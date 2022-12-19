package app.my.myapp.services;

import app.my.myapp.model.Product;

public interface ProductService {
    void addProduct(Product product);

    boolean changeProduct(String productName, Integer unit, Integer count);

    boolean removeProduct(String productName);

    Product getProduct(String productName);
}
