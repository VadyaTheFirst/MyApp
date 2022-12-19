package app.my.myapp.controllers;

import app.my.myapp.model.Receipe;
import app.my.myapp.services.ProductService;
import app.my.myapp.services.ReceipeServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("Recepies")
@Tag(name = "Рецепты",description = "CRUD-операции над рецептами")

public class ReceipeController {

    private ReceipeServices receipeServices;


    public ReceipeController(ReceipeServices receipeServices, ProductService productService) {
        this.receipeServices = receipeServices;
    }



    @PostMapping("/")
    public ResponseEntity<String> postReceipe(@RequestBody Receipe receipe) {
        receipeServices.addReceipe(receipe);
        return ResponseEntity.ok("Рецепт добавлен");
    }

    @GetMapping("/{number}")
    public ResponseEntity<Receipe> cout(@PathVariable Integer number) {
        //Integer num= Integer.parseInt(number);
        var answer = receipeServices.getReceipe(number);
        if (answer == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(answer);
        }
    }

    @PutMapping("/{number}")
    public ResponseEntity<String> putReceipe(@RequestBody Receipe receipe, @PathVariable Integer number) {
        //Integer num= Integer.parseInt(number);
        if (receipeServices.getReceipe(number) == null) {
            return ResponseEntity.notFound().build();
        } else {
            receipeServices.changeReceipe(number, receipe);
            return ResponseEntity.ok("Рецепт изменен");
        }
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteReceipe(@PathVariable Integer number) {
       // Integer num= Integer.parseInt(number);
        if (receipeServices.getReceipe(number) == null) {
            return ResponseEntity.notFound().build();
        } else {
            receipeServices.removeReceipe(number);
            return ResponseEntity.ok("Рецепт удален");
        }
    }


}
