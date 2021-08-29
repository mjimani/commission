package ir.mjimani.commission.service.product;


import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;

import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring service interface for the {@link Product} entity.
 */
public interface ProductService {

    String create(Product product) throws CustomException;

    Boolean updateById(String id, Product product) throws CustomException;

    List<Product> getList() throws CustomException;

    Product getOneById(String id) throws CustomException;

    Boolean deleteById(String id) throws CustomException;
}
