package boot.mvc.ex1;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString

@Data // 이거 하나면 @Setter,@Getter,@ToString 3개 하는것과 동일한 효과를 가져온다.
// lombok을 깔아서 Setter,Getter 생성을 따로 안해도 된다. 

public class TestDto {

	private String name;
	private String addr;
}
