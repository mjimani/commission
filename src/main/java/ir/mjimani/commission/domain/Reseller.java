package ir.mjimani.commission.domain;

import ir.mjimani.commission.exception.error.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author MjImani
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reseller {

    private String id;

    private String firstName;

    private String lastName;

    private String identity;

    private String phone;

    private Date creationDate;

    private Date modifyDate;

    public void validation() throws CustomException {
        if (firstName == null || firstName.trim().isEmpty()){
            throw new CustomException("FirstName is empty.");
        }
        if (lastName == null || lastName.trim().isEmpty()){
            throw new CustomException("LastName is empty.");
        }
        if (identity == null || identity.trim().isEmpty()){
            throw new CustomException("Identity is empty.");
        }
        if (phone == null || phone.trim().isEmpty()){
            throw new CustomException("Phone is empty.");
        }
    }
}
