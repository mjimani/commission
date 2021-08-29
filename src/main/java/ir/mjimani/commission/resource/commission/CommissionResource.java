package ir.mjimani.commission.resource.commission;

import ir.mjimani.commission.domain.Commission;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring rest controller interface for the {@link Commission} entity.
 */
@RequestMapping("api/commission")
public interface CommissionResource {

    @PostMapping
    ResponseEntity<String> create(@RequestBody Commission commission) throws CustomException;

    @PutMapping
    ResponseEntity<Boolean> updateById(@RequestParam("id") String id,
                                       @RequestBody Commission commission) throws CustomException;

    @GetMapping
    ResponseEntity<List<Commission>> getList() throws CustomException;

    @GetMapping
    ResponseEntity<Commission> getOneById(@RequestParam("id") String id) throws CustomException;

    @DeleteMapping
    ResponseEntity<Boolean> deleteById(@RequestParam("id") String id) throws CustomException;

}


