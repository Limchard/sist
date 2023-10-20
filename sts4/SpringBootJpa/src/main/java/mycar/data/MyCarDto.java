package mycar.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity // 기본 설정
@Table(name="mycar") // 자동으로 mysql에 mycar 라는 table이 만들어진다.
@Data
public class MyCarDto {

	@Id // 각 엔티티를 구별할 수 있는 식별 id 이다. 즉 seq라고 봐도 된다. 기본키, primary key를 지정하는 것. // Id만 써도 된다 라고 하는데.. 보통 쌤은 2개 쓴다.
	@GeneratedValue(strategy = GenerationType.AUTO) // 이것도 엔티티를 구별할 수 있는 식별자. 
	private long num;
	
	// 멤버등록하기
	@Column(name = "carname") // 이름을 지정할 시에 이름을 지정해줘야 한다.	
	private String carname;
	
	@Column // 이름을 똑같이 쓸 경우 안써도 된다.
	private int carprice;
	
	@Column
	private String carcolor;
	
	@Column
	private String carguip;
	
	@CreationTimestamp // 엔티티가 생성되는 시점의 시간을 자동지정. 날짜는 now()로 해서 바로 기입되잖아 ^^
	@Column(updatable = false) // 업데이트시에 이 컬럼은 수정하지 않겠다. 이게 없으면 값이 null로 들어간다(자동 업데이트). updateform에 해당 guipday를 기입하지 않기 때문이다.
	private Timestamp guipday;
	
}
