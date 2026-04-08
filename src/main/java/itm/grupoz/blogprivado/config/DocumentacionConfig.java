package itm.grupoz.blogprivado.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentacionConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("API de prueba y documentación")
                                .version("1.0")
                                .description("Esta es una API de prueba.")
                                .contact(new Contact().name("Juan").email("juanisaza1114966@correo.itm.edu.com")));
    }
}
