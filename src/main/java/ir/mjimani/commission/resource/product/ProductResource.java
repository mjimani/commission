package ir.mjimani.commission.resource.product;

import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring rest controller interface for the {@link Product} entity.
 */
@RequestMapping("api/product")
public interface ProductResource {

    @PostMapping
    ResponseEntity<String> create(@RequestBody Product product) throws CustomException;

    @PutMapping
    ResponseEntity<Boolean> updateById(@RequestParam("id") String id,
                                      @RequestBody Product product) throws CustomException;

    @GetMapping
    ResponseEntity<List<Product>> getList() throws CustomException;

    @GetMapping("{id}")
    ResponseEntity<Product> getOneById(@PathVariable("id") String id) throws CustomException;

    @DeleteMapping
    ResponseEntity<Boolean> deleteById(@RequestParam("id") String id) throws CustomException;

}


