package app.my.myapp.controllers;

import app.my.myapp.model.Product;
import app.my.myapp.model.Receipe;
import app.my.myapp.services.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Products")
@Tag(name = "Продукты",description = "CRUD-операции над продуктами")

public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/{productName}")
    @Operation(
        summary="Получить продукт",
        description = "Получить информацию о продукте"
            )
    @ApiResponse(
          responseCode = "200",
          description = "Продукт найден"
    )

    public Product getProduct(@PathVariable String productName) {
        return productService.getProduct(productName);
    }

    @DeleteMapping("/{productName}")
    @Operation(
            summary="Удалить продукт",
            description = "Удалить информацию о продукте"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Продукт удален"
    )
    public ResponseEntity<String> deleteProduct(@PathVariable String productName) {
        if (productService.removeProduct(productName)) {
            return ResponseEntity.ok("Продукт удален");
        } else {
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{productName}")
    @Operation(
            summary="Изменить продукт",
            description = "Изменить информацию о продукте"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Продукт изменен"
    )

    public ResponseEntity<String> postReceipe(@PathVariable String productName,@RequestParam Integer unit,@RequestParam Integer count) {
        if (productService.changeProduct(productName, unit, count)) {
            return ResponseEntity.ok("Продукт изменен");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{productName}")
    @Operation(
            summary="Добваить продукт",
            description = "Добавить новый продукте"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Продукт добавлен"
    )

    public ResponseEntity<String> putReceipe(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Продукт добавлен");
    }
}






