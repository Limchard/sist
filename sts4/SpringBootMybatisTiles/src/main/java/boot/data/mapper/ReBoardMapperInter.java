package boot.data.mapper;

import boot.data.dto.ReBoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReBoardMapperInter {
    public  int getMaxNum();
    public int getTotalCount(Map<String,String>map);
    public List<ReBoardDto>getPagingList(Map<String,Object>map); // 검색어도 같이 넘겨야 하기 때문에 Object 사용 함.
    public void insertReBoard(ReBoardDto dto);
    public void updateRestep(Map<String,Integer>map);
    public void updateReadCount(int num);
    public  ReBoardDto getData(int num);
    public void updateReBoard(ReBoardDto dto);
    public void deleteReBoard(int num);
    public void updateLikes(int num);


}
