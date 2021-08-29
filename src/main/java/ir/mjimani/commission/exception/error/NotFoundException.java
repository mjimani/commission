package ir.mjimani.commission.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author MjImani at 2021-06-17
 * email : mjimani.ir@gmail.com
 * phone : +989191414931
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends Exception {

    private String message;

    private int statusNumber;

    public NotFoundException(String message) {
        this.message = message;
        this.statusNumber = 404;
    }

}
