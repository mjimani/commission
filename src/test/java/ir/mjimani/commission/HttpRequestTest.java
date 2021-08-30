package ir.mjimani.commission;

import ir.mjimani.commission.domain.Commission;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public String createCommission_returnNewCommissionId() throws Exception {
        Commission commission = new Commission();
        commission.setResellerId(new ObjectId().toString());
        commission.setProductIds(Collections.singleton(new ObjectId().toString()));
        commission.setShare(20);
        ResponseEntity<String> commissionId = this.restTemplate.postForEntity("http://localhost:" + port + "/api/commission", commission, String.class);

        assertThat(commissionId.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(commissionId.getBody()).isNotNull();
        return commissionId.getBody();
    }

    @Test
    public void deleteCommission() throws Exception {
        String commissionId = createCommission_returnNewCommissionId();
        Commission commission = this.restTemplate.getForObject("http://localhost:" + port + "/api/commission/" + commissionId, Commission.class);
        assertThat(commission).isNotNull();

        this.restTemplate.delete("http://localhost:" + port + "/api/commission?id=" + commissionId);

        commission = this.restTemplate.getForObject("http://localhost:" + port + "/api/commission/" + commissionId, Commission.class);
        if (commission == null){
            assert true;
        }else {
            Assert.fail();
        }

    }
}