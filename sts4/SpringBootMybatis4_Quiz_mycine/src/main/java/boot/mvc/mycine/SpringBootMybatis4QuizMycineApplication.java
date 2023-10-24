package boot.mvc.mycine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("boot.mvc.cine") // 패키징 등록
@EntityScan("boot.mvc.cine") // dto 인식
@EnableJpaRepositories("boot.mvc.cine") // dao 인식
public class SpringBootMybatis4QuizMycineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatis4QuizMycineApplication.class, args);
	}

}
