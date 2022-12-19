package app.my.myapp.services;

import app.my.myapp.model.Receipe;

import java.util.Map;

public interface ReceipeServices {

    void addReceipe(Receipe receipe);

    void changeReceipe(Integer number, Receipe receipe);

    Receipe getReceipe(Integer number);

    void removeReceipe(Integer number);


}
