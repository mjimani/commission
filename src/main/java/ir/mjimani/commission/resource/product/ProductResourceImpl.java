package ir.mjimani.commission.resource.product;

import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;
import ir.mjimani.commission.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author MjImani
 * Spring rest controller for the {@link Product} entity.
 */
@RestController
@RequiredArgsConstructor
public class ProductResourceImpl implements ProductResource {

    private final ProductService entityService;

    @Override
    public ResponseEntity<String> create(Product product) throws CustomException {
        product.validation();
        return ResponseEntity.ok(entityService.create(product));
    }

    @Override
    public ResponseEntity<Boolean> updateById(String id, Product product) throws CustomException {
        if (id == null || id.trim().isEmpty()) {
            throw new CustomException("Id is not valid.");
        }
        product.validation();
        return ResponseEntity.ok(entityService.updateById(id, product));
    }

    @Override
    public ResponseEntity<List<Product>> getList() throws CustomException {
        return ResponseEntity.ok(entityService.getList());
    }

    @Override
    public ResponseEntity<Product> getOneById(String id) throws CustomException {
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


