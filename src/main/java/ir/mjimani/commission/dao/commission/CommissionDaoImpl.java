package ir.mjimani.commission.dao.commission;


import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ir.mjimani.commission.domain.Commission;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.exception.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author MjImani
 * <p>
 * Spring Data MongoDb dao implementation for the {@link Commission} entity.
 */
@Repository
@RequiredArgsConstructor
public class CommissionDaoImpl implements CommissionDao {

    private final MongoTemplate mongoTemplate;

    @Override
    public Commission create(Commission commission) throws CustomException {
        try {
            return mongoTemplate.save(commission);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Boolean updateById(String id, Commission commission) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));

            Update update = new Update();
            update.set("productIds", commission.getProductIds());
            update.set("share", commission.getShare());
            update.set("modifyDate", new Date());

            UpdateResult result = mongoTemplate.updateFirst(query, update, Commission.class);

            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public List<Commission> getList() throws CustomException {
        try {
            return mongoTemplate.find(new Query(), Commission.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Commission getOneById(String id) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));

            return mongoTemplate.findOne(query, Commission.class);
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

            DeleteResult result = mongoTemplate.remove(query, Commission.class);
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Boolean checkExistsByResellerIdAndProductIds(String resellerId, Set<String> productIds) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(new Criteria().andOperator(
                    Criteria.where("resellerId").is(resellerId),
                    Criteria.where("productIds").in(productIds)
            ));

            return mongoTemplate.exists(query, Commission.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Boolean checkExistsByResellerIdAndProductIds(String resellerId, Set<String> productIds, String ignoreId) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(new Criteria().andOperator(
                    Criteria.where("id").ne(ignoreId),
                    Criteria.where("resellerId").is(resellerId),
                    Criteria.where("productIds").in(productIds)
            ));

            return mongoTemplate.exists(query, Commission.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }
}


