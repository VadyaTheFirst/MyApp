package app.my.myapp.services;

import java.io.File;

public interface FileServices {

    boolean saveToFile(String json);

    String readFromFile();

    boolean cleanFile();

    File getDataFile();


//    boolean saveToFile(Object object, String fileName);
}
