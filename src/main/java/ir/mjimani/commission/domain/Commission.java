package ir.mjimani.commission.domain;

import ir.mjimani.commission.exception.error.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * @author MjImani
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Commission {

    private String id;

    private String resellerId;

    private Set<String> productIds;

    private Integer share;

    private Date creationDate;

    private Date modifyDate;

    public void validation() throws CustomException {
        if (resellerId == null || resellerId.trim().isEmpty()) {
            throw new CustomException("ResellerId is empty");
        }
        if (productIds == null || productIds.isEmpty()) {
            throw new CustomException("ProductIds is empty.");
        }
        if (share == null || share <= 0 || share > 100) {
            throw new CustomException("Share is not valid.");
        }
    }
}
