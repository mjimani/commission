package ir.mjimani.commission.resource.product;

import ir.mjimani.commission.domain.Product;
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

/**
 * @author MjImani
 * Spring rest controller for the {@link Product} entity.
 */
@RestController
@RequiredArgsConstructor
public class ProductResourceImpl implements ProductResource {

    private final ProductService entityService;

}


