package ir.mjimani.commission.domain;

import ir.mjimani.commission.exception.error.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author MjImani
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;

    private String title;

    private Long price;

    private Date creationDate;

    private Date modifyDate;

    public void validation() throws CustomException {
        if (title == null || title.trim().isEmpty())
            throw new CustomException("Title is empty");

        if (price == null || price <= 0)
            throw new CustomException("Price is not valid.");
    }
}
