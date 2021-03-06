package ir.mjimani.commission.dao.product;


import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
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

/**
 * @author MjImani
 * <p>
 * Spring Data MongoDb dao implementation for the {@link Product} entity.
 */
@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

    private final MongoTemplate mongoTemplate;

    @Override
    public Product create(Product product) throws CustomException {
        try {
            return mongoTemplate.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Boolean updateById(String id, Product product) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));

            Update update = new Update();
            update.set("title", product.getTitle());
            update.set("modifyDate", new Date());

            UpdateResult result = mongoTemplate.updateFirst(query, update, Product.class);

            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public List<Product> getList() throws CustomException {
        try {
            return mongoTemplate.find(new Query(), Product.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }

    @Override
    public Product getOneById(String id) throws CustomException {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(id));

            return mongoTemplate.findOne(query, Product.class);
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

            DeleteResult result =  mongoTemplate.remove(query, Product.class);
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("MongoDb error.", 500);
        }
    }
}


