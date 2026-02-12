package net.engineeringdigest.journalApp.Controller;

import lombok.RequiredArgsConstructor;
import net.engineeringdigest.journalApp.Dto.*;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = authService.login(request);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("userId", user.getId());

        return ResponseEntity.ok(response);
    }
}
