package app.my.myapp.services.impl;

import app.my.myapp.model.Product;
import app.my.myapp.model.Receipe;
import app.my.myapp.services.FileServices;
import app.my.myapp.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ProductServiceImpl implements ProductService {


    private static List<Product> products = new LinkedList<>();
    static FileServicesImpl fileService;
    public ProductServiceImpl(FileServicesImpl fileService) {
        this.fileService =fileService;
    }
    @PostConstruct
    public void  init(){
        readFromFile();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
        saveToFile();
    }

    @Override
    public boolean changeProduct(String productName, Integer unit, Integer count) {
        boolean productExists = false;
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                product.setUnit(unit);
                product.setCount(count);
                productExists = true;
                saveToFile();
            }
        }
        return productExists;
    }


    @Override
    public boolean removeProduct(String productName) {
        boolean productExists = false;
        Product del = null;
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                del = product;
                productExists = true;
            }
        }
        if (productExists) {
            products.remove(del);
        }
        return productExists;
    }



    @Override
    public Product getProduct(String productName){
        Product prod=null;
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
               prod=product;
            }
        }
        return prod;
    }


    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(products);
            fileService.saveToFile(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        String json = fileService.readFromFile();
        try {
            products = new ObjectMapper().readValue(json, new TypeReference<LinkedList<Product>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}
