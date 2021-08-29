package ir.mjimani.commission.dao.commission;


import ir.mjimani.commission.domain.Commission;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;

import java.util.List;
import java.util.Set;

/**
 * @author MjImani
 * <p>
 * Spring Data MongoDb dao interface for the {@link Commission} entity.
 */
public interface CommissionDao {

    Commission create(Commission commission) throws CustomException;

    Boolean updateById(String id, Commission commission) throws CustomException;

    List<Commission> getList() throws CustomException;

    Commission getOneById(String id) throws CustomException;

    Boolean deleteById(String id) throws CustomException;

    Boolean checkExistsByResellerIdAndProductIds(String resellerId, Set<String> productIds) throws CustomException;

    Boolean checkExistsByResellerIdAndProductIds(String resellerId, Set<String> productIds, String ignoreId) throws CustomException;
}

