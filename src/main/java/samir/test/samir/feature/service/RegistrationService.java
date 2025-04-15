package samir.test.samir.feature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import samir.test.samir.feature.UserDto;
import samir.test.samir.feature.model.User;
import samir.test.samir.repository.UserRepository;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(UserDto userDto) throws Exception {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new Exception("Username already exists");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
    }
}
