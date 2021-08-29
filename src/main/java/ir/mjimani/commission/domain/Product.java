package ir.mjimani.commission.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
