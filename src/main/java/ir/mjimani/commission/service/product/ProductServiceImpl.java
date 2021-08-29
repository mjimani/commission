package ir.mjimani.commission.service.product;

import ir.mjimani.commission.dao.product.ProductDao;
import ir.mjimani.commission.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author MjImani
 * <p>
 * Spring service implementation for the {@link Product} entity.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao entityDao;

}
