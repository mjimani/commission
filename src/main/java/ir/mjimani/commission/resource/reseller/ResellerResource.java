package ir.mjimani.commission.resource.reseller;

import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.domain.Reseller;
import ir.mjimani.commission.exception.error.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring rest controller interface for the {@link Reseller} entity.
 */
@RequestMapping("api/reseller")
public interface ResellerResource {

    @PostMapping
    ResponseEntity<String> create(@RequestBody Reseller reseller) throws CustomException;

    @PutMapping
    ResponseEntity<Boolean> updateById(@RequestParam("id") String id,
                                       @RequestBody Reseller reseller) throws CustomException;

    @GetMapping
    ResponseEntity<List<Reseller>> getList() throws CustomException;

    @GetMapping("{id}")
    ResponseEntity<Reseller> getOneById(@PathVariable("id") String id) throws CustomException;

    @DeleteMapping
    ResponseEntity<Boolean> deleteById(@RequestParam("id") String id) throws CustomException;
}


