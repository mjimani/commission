package ir.mjimani.commission;

import ir.mjimani.commission.resource.commission.CommissionResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CommissionTest {

	@Autowired
	private CommissionResource commissionResource;

	@Test
	public void contextLoads() throws Exception {

		assertThat(commissionResource).isNotNull();
	}
}