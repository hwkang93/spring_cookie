package hwkang.cookie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CookieApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookieApplication.class, args);
	}

}
