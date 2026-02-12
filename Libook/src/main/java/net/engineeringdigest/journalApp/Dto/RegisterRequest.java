package net.engineeringdigest.journalApp.Dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
