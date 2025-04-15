package samir.test.samir.feature.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import samir.test.samir.feature.model.User;
import samir.test.samir.repository.UserRepository;
import samir.test.samir.security.JwtUtil;
import samir.test.samir.util.AESCrypto;

import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Map<String, String> login(Map<String, String> body) throws Exception {
        String username = body.get("username");
        String password = body.get("password");
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        String token = jwtUtil.generateToken(username, user.getId());
        return Map.of("token", token);
    }
}
