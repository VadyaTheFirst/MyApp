package app.my.myapp.services.impl;

import app.my.myapp.model.Receipe;
import app.my.myapp.services.ReceipeServices;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service

public class ReceipeServicesImpl implements ReceipeServices {


    private static Integer id = 1;

    private static Map<Integer, Receipe> receipes = new TreeMap<>();


    @Override
    public void addReceipe(Receipe receipe) {
        receipes.put(id, receipe);
        id++;
    }

    public Receipe getReceipe(Integer number) {
        return receipes.get(number);
    }

    public void changeReceipe(Integer number, Receipe receipe) {
        receipes.put(number, receipe);
    }

    public void removeReceipe(Integer number) {
        receipes.remove(number);
    }

}



