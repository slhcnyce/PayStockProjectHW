package com.example.paystockbackend.auth;
  
import com.example.paystockbackend.model.StatusModel; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 

@RestController
public class AuthController {

	  @Autowired
	    private AuthRepository authRepository;
 
	    @PostMapping("/authentication")
	    public StatusModel authenticateRenter(@RequestBody AuthDto loginRequest) {
	        String username = loginRequest.getUsername();
	        String password = loginRequest.getPassword();

	        // Kullanıcıyı kullanıcı adıyla bul
	        Optional<AuthDto> renterOptional = authRepository.findByUsername(username);

	        if (!renterOptional.isPresent()) {
	            // Kullanıcı bulunamazsa
	            return new StatusModel(false);
	        }

	        // Kullanıcı bulunduysa, şifreyi kontrol et
	        AuthDto authDto = renterOptional.get();
	        if (!authDto.getPassword().equals(password) || !authDto.getRenterCode().equals(loginRequest.getRenterCode())) {
	            // Şifre uyuşmazlığı
	        	 return new StatusModel(false);
	        }

	        // Başarılı doğrulama
	        return new StatusModel(true);
	    }
	    
	    @PostMapping("/addUser")
	    public void addUser(@RequestBody AuthDto loginRequest) {
	    	authRepository.save(loginRequest);
	    }
	     
}