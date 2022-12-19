package app.my.myapp.services.impl;

import app.my.myapp.services.FileServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service

public class FileServicesImpl implements FileServices {
    @Value("${pathToFile}")
    private String pathToFile;

    @Value("${nameOfProductFile}")
    private String nameOfProductFile;


    @Override
    public boolean saveToFile(String json) {
        try {
            removeFile();
            Files.writeString(Path.of(pathToFile, nameOfProductFile), json);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readFromFile(){
        try {
            return Files.readString(Path.of(pathToFile, nameOfProductFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean removeFile(){
        try {
            Path path = Path.of(pathToFile, nameOfProductFile);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
