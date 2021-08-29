package ir.mjimani.commission.service.commission;


import ir.mjimani.commission.domain.Commission;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;

import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring service interface for the {@link Commission} entity.
 */
public interface CommissionService {

    String create(Commission commission) throws CustomException;

    Boolean updateById(String id, Commission commission) throws CustomException;

    List<Commission> getList() throws CustomException;

    Commission getOneById(String id) throws CustomException;

    Boolean deleteById(String id) throws CustomException;

}
