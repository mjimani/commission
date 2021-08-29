package ir.mjimani.commission.resource.commission;

import ir.mjimani.commission.domain.Commission;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;
import ir.mjimani.commission.service.commission.CommissionService;
import ir.mjimani.commission.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MjImani
 * Spring rest controller for the {@link Commission} entity.
 */
@RestController
@RequiredArgsConstructor
public class CommissionResourceImpl implements CommissionResource {

    private final CommissionService entityService;


    @Override
    public ResponseEntity<String> create(Commission commission) throws CustomException {
        commission.validation();
        return ResponseEntity.ok(entityService.create(commission));
    }

    @Override
    public ResponseEntity<Boolean> updateById(String id, Commission commission) throws CustomException {
        if (id == null || id.trim().isEmpty()) {
            throw new CustomException("Id is not valid.");
        }
        commission.validation();
        return ResponseEntity.ok(entityService.updateById(id, commission));
    }

    @Override
    public ResponseEntity<List<Commission>> getList() throws CustomException {
        return ResponseEntity.ok(entityService.getList());
    }

    @Override
    public ResponseEntity<Commission> getOneById(String id) throws CustomException {
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


