package ir.mjimani.commission.resource.commission;

import ir.mjimani.commission.domain.Commission;
import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.service.commission.CommissionService;
import ir.mjimani.commission.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MjImani
 * Spring rest controller for the {@link Commission} entity.
 */
@RestController
@RequiredArgsConstructor
public class CommissionResourceImpl implements CommissionResource {

    private final CommissionService entityService;

}


