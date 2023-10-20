package boot.mvc.tea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"mycar.data"})// 패키징 등록
@EntityScan("mycar.data") // table이 어디에 생성되는지 지정 // dto 인식
@EnableJpaRepositories("mycar.data") // dao인식 (method인식) // Repositoriy를 bean에 자동 등록해줘!!
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

}
