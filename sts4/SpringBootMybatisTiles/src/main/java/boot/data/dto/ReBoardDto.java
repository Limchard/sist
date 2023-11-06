package boot.data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("redto")
public class ReBoardDto {

    private int num;
    private int readcount;
    private int likes;
    private int regroup;
    private int restep;
    private int relevel;
    private String id;
    private String name;
    private String subject;
    private String content;
    private String photo;
    private Timestamp writeday;

}
