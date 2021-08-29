package ir.mjimani.commission.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
