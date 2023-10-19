package boot.mvc.ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.test","hello.boot","my.info"}) // 패키징 등록하는것. 복수일때에는 반드시 {}안에 해줘야 한다.
public class SpringBootEx111Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx111Application.class, args);
	}
	
}
