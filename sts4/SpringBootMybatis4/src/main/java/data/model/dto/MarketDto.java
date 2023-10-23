package data.model.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data // lombok 적용
@Alias("mdto") // spring framework 에서는 config 에서 따로 지정해줬던거를 여기서는 이렇게 간단하게 설정 가능하다!!
public class MarketDto {

	private String num;
	
	private int	price; 
	private String sang;
	private String photoname;
	private Timestamp ipgoday;
	
}
