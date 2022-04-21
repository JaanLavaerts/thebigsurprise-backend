package ucll.thebigsurprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RestController;

@EnableOAuth2Sso
@SpringBootApplication
public class ThebigsurpriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThebigsurpriseApplication.class, args);
	}



}
