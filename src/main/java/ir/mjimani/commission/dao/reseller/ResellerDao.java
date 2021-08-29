package ir.mjimani.commission.dao.reseller;


import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.domain.Reseller;
import ir.mjimani.commission.exception.error.CustomException;

import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring Data MongoDb dao interface for the {@link Reseller} entity.
 */
public interface ResellerDao {

    Reseller create(Reseller reseller) throws CustomException;

    Boolean updateById(String id, Reseller reseller) throws CustomException;

    List<Reseller> getList() throws CustomException;

    Reseller getOneById(String id) throws CustomException;

    Boolean deleteById(String id) throws CustomException;
}

