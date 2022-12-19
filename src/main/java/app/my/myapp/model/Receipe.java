package app.my.myapp.model;

import lombok.AllArgsConstructor;//конструктор со всеми параметрами
import lombok.Data;//содержит еквилсы, хэшкоды и конструктор
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor //Пустой конструктор для создания полей
public class Receipe {

 private String name;
 private Integer time;
 private List<Product> products = new ArrayList<>();
 private LinkedList<String> steps= new LinkedList<String>();

}
