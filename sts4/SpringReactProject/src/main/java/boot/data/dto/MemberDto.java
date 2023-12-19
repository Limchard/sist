package boot.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("memberDto")
public class MemberDto {
    private int num;
    private String name;
    private String id;
    private String pass;
    private String hp;
    private String addr;
    private String email;
    @JsonFormat(pattern="yyyy.MM.dd")
    private Timestamp gaipday;
}
