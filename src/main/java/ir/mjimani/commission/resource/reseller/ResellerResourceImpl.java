package ir.mjimani.commission.resource.reseller;

import ir.mjimani.commission.domain.Product;
import ir.mjimani.commission.domain.Reseller;
import ir.mjimani.commission.service.product.ProductService;
import ir.mjimani.commission.service.reseller.ResellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MjImani
 * Spring rest controller for the {@link Reseller} entity.
 */
@RestController
@RequiredArgsConstructor
public class ResellerResourceImpl implements ResellerResource {

    private final ResellerService entityService;

}


