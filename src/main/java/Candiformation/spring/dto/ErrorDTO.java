package Candiformation.spring.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

@Getter
@Setter
public class ErrorDTO {
    private final int status;
    private final String message;
    private boolean success = false;

    public ErrorDTO(int status, boolean success, String message) {
        this.status = status;
        this.success = success;
        this.message = message;
    }
}
