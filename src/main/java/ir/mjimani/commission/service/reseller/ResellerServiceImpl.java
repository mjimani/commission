package ir.mjimani.commission.service.reseller;

import ir.mjimani.commission.dao.product.ProductDao;
import ir.mjimani.commission.dao.reseller.ResellerDao;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.domain.Reseller;
import ir.mjimani.commission.exception.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring service implementation for the {@link Reseller} entity.
 */
@Service
@RequiredArgsConstructor
public class ResellerServiceImpl implements ResellerService {

    private final ResellerDao entityDao;

    @Override
    public String create(Reseller reseller) throws CustomException {
        reseller.setId(null);
        reseller.setCreationDate(new Date());
        // Save
        reseller = entityDao.create(reseller);
        return reseller.getId();
    }

    @Override
    public Boolean updateById(String id, Reseller reseller) throws CustomException {
        return entityDao.updateById(id, reseller);
    }

    @Override
    public List<Reseller> getList() throws CustomException {
        return entityDao.getList();
    }

    @Override
    public Reseller getOneById(String id) throws CustomException {
        return entityDao.getOneById(id);
    }

    @Override
    public Boolean deleteById(String id) throws CustomException {
        return entityDao.deleteById(id);
    }
}
