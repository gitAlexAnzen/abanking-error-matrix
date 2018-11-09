package mx.com.anzen.app.abanking.error.matrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p> Main class to load resource for the app </p>
 * 
 * @version abanking-error-matrix
 * @since abanking-error-matrix
 */

@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories({
	"mx.com.anzen.app.abanking.error.matrix.jpa.repository"
})
@EntityScan({
	"mx.com.anzen.app.abanking.error.matrix.jpa.model"
})
@SpringBootApplication
public class Application {

	/**
	 * <p> Method to initialize the spring boot project architecture. </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
}
