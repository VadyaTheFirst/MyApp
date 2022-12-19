package app.my.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //Чтобы работал метод инит- изначально будет создан пустой файл
public class Product {
    private String productName;
    private Integer count;
    private Integer unit;

}
