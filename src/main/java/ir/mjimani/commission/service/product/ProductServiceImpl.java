package ir.mjimani.commission.service.product;

import ir.mjimani.commission.dao.product.ProductDao;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring service implementation for the {@link Product} entity.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao entityDao;

    @Override
    public String create(Product product) throws CustomException {
        product.setId(null);
        product.setCreationDate(new Date());
        // Save
        product = entityDao.create(product);
        return product.getId();
    }

    @Override
    public Boolean updateById(String id, Product product) throws CustomException {
        return entityDao.updateById(id, product);
    }

    @Override
    public List<Product> getList() throws CustomException {
        return entityDao.getList();
    }

    @Override
    public Product getOneById(String id) throws CustomException {
        return entityDao.getOneById(id);
    }

    @Override
    public Boolean deleteById(String id) throws CustomException {
        return entityDao.deleteById(id);
    }
}
