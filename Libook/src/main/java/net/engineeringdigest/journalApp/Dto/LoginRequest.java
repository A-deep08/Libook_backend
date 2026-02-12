package net.engineeringdigest.journalApp.Dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}
