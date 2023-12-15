package boot.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("ShopDto")
public class ShopDto {
    private int num;
    private String sangpum;
    private String photo;
    private int su;
    private int dan;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp ipgoday;

}
