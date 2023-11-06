package boot.data.service;

import boot.data.dto.ReBoardDto;

import java.util.List;
import java.util.Map;

public interface ReBoardServiceInter {

    public  int getMaxNum();
    public int getTotalCount(String searchcolumn, String searchword);
    public List<ReBoardDto> getPagingList(String searchcolumn, String searchword,int startnum,int perpage); // 검색어도 같이 넘겨야 하기 때문에 Object 사용 함.
    public void insertReBoard(ReBoardDto dto);
    public void updateRestep(int regroup,int restep);
    public void updateReadCount(int num);
    public  ReBoardDto getData(int num);
    public void updateReBoard(ReBoardDto dto);
    public void deleteReBoard(int num);
    public void updateLikes(int num);
}
