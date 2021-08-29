package ir.mjimani.commission.dao.reseller;


import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.domain.Reseller;
import ir.mjimani.commission.exception.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author MjImani
 * <p>
 * Spring Data MongoDb dao implementation for the {@link Reseller} entity.
 */
@Repository
@RequiredArgsConstructor
public class ResellerDaoImpl implements ResellerDao {

    private final MongoTemplate mongoTemplate;

    @Override
    public Reseller create(Reseller reseller) throws CustomException {
        try {
            return mongoTemplate.save(reseller);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Boolean updateById(String id, Reseller reseller) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));

            Update update = new Update();
            update.set("firstName", reseller.getFirstName());
            update.set("lastName", reseller.getLastName());
            update.set("identity", reseller.getIdentity());
            update.set("phone", reseller.getPhone());
            update.set("modifyDate", new Date());

            UpdateResult result = mongoTemplate.updateFirst(query, update, Reseller.class);

            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public List<Reseller> getList() throws CustomException {
        try {
            return mongoTemplate.find(new Query(), Reseller.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Reseller getOneById(String id) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));

            return mongoTemplate.findOne(query, Reseller.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Boolean deleteById(String id) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));

            DeleteResult result = mongoTemplate.remove(query, Reseller.class);
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }
}


