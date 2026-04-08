package itm.grupoz.blogprivado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BlogprivadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogprivadoApplication.class, args);
	}

}
