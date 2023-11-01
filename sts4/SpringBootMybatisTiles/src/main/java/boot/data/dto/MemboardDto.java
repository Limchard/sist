package boot.data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("memboard")
public class MemboardDto {

	private String num;
	private String name;
	private String myid;
	private String subjects; 
	private String content;
	private String uploadfile;
	private MultipartFile upload; // 인자값 미리 만들어놓기
	private int readcount;
	private Timestamp writeday;

}
