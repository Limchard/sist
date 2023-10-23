package boot.mvc.sist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("data.model.*")
@MapperScan("data.model.mapper") // mapper 등록... 이 위치에 mapper가 위치한다!! 기존에 bean에 등록하던거 대신해서 interface에 해당하는 것 등록함.
public class SpringBootMybatis4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatis4Application.class, args);
	}

}
