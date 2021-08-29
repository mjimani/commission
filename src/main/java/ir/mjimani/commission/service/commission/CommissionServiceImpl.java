package ir.mjimani.commission.service.commission;

import ir.mjimani.commission.dao.commission.CommissionDao;
import ir.mjimani.commission.dao.product.ProductDao;
import ir.mjimani.commission.domain.Commission;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring service implementation for the {@link Commission} entity.
 */
@Service
@RequiredArgsConstructor
public class CommissionServiceImpl implements CommissionService {

    private final CommissionDao entityDao;


    @Override
    public String create(Commission commission) throws CustomException {
        commission.setId(null);
        commission.setCreationDate(new Date());
        // Check unique
        Boolean existsCommission = entityDao.checkExistsByResellerIdAndProductIds(commission.getResellerId(), commission.getProductIds());
        if (existsCommission) {
            throw new CustomException("You have already made commission with this specification");
        }

        // Save
        commission = entityDao.create(commission);
        return commission.getId();
    }

    @Override
    public Boolean updateById(String id, Commission commission) throws CustomException {
        // Check unique
        Boolean existsCommission = entityDao.checkExistsByResellerIdAndProductIds(commission.getResellerId(), commission.getProductIds(), id);
        if (existsCommission) {
            throw new CustomException("You have already made commission with this specification");
        }
        return entityDao.updateById(id, commission);
    }

    @Override
    public List<Commission> getList() throws CustomException {
        return entityDao.getList();
    }

    @Override
    public Commission getOneById(String id) throws CustomException {
        return entityDao.getOneById(id);
    }

    @Override
    public Boolean deleteById(String id) throws CustomException {
        return entityDao.deleteById(id);
    }

}
