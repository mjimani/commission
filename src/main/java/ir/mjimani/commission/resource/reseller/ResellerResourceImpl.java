package ir.mjimani.commission.resource.reseller;

import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.domain.Reseller;
import ir.mjimani.commission.exception.error.CustomException;
import ir.mjimani.commission.service.product.ProductService;
import ir.mjimani.commission.service.reseller.ResellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MjImani
 * Spring rest controller for the {@link Reseller} entity.
 */
@RestController
@RequiredArgsConstructor
public class ResellerResourceImpl implements ResellerResource {

    private final ResellerService entityService;


    @Override
    public ResponseEntity<String> create(Reseller reseller) throws CustomException {
        reseller.validation();
        return ResponseEntity.ok(entityService.create(reseller));
    }

    @Override
    public ResponseEntity<Boolean> updateById(String id, Reseller reseller) throws CustomException {
        if (id == null || id.trim().isEmpty()) {
            throw new CustomException("Id is not valid.");
        }
        reseller.validation();
        return ResponseEntity.ok(entityService.updateById(id, reseller));
    }

    @Override
    public ResponseEntity<List<Reseller>> getList() throws CustomException {
        return ResponseEntity.ok(entityService.getList());
    }

    @Override
    public ResponseEntity<Reseller> getOneById(String id) throws CustomException {
        if (id == null || id.trim().isEmpty()) {
            throw new CustomException("Id is not valid.");
        }
        return ResponseEntity.ok(entityService.getOneById(id));
    }

    @Override
    public ResponseEntity<Boolean> deleteById(String id) throws CustomException {
        if (id == null || id.trim().isEmpty()) {
            throw new CustomException("Id is not valid.");
        }
        return ResponseEntity.ok(entityService.deleteById(id));
    }

}


