package ir.mjimani.commission.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
/**
 * @author MjImani at 2021-06-17
 * email : mjimani.ir@gmail.com
 * phone : +989191414931
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends Exception {

    private String message;

    private HttpStatus status;

    private int statusNumber;

    public CustomException(String message) {
        this.message = message;
        status = HttpStatus.BAD_REQUEST;
    }

    public CustomException(String message, int statusNumber) {
        this.message = message;
        this.statusNumber = statusNumber;
    }

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

}
