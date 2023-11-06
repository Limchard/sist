package boot.data.service;

import boot.data.dto.ReBoardDto;
import boot.data.mapper.ReBoardMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReBoardService implements ReBoardServiceInter {

    @Autowired
    ReBoardMapperInter mapperInter;

    @Override
    public int getMaxNum() {
        return mapperInter.getMaxNum();
    }

    @Override
    public int getTotalCount(String searchcolumn, String searchword) {
        Map<String,String>map=new HashMap<>();
        map.put("searchword",searchword);
        map.put("searchcolumn",searchcolumn);
        return mapperInter.getTotalCount(map);
    }

    @Override
    public List<ReBoardDto> getPagingList(String searchcolumn, String searchword, int startnum, int perpage) {
        Map<String,Object>map=new HashMap<>();
        map.put("searchcolumn",searchcolumn);
        map.put("searchcolumn",searchword);
        map.put("startnum",startnum);
        map.put("perpage",perpage);
        return mapperInter.getPagingList(map);
    }

    @Override
    public void insertReBoard(ReBoardDto dto) {
        int num=dto.getNum();
        int regroup=dto.getRegroup();
        int restep=dto.getRestep();
        int relevel=dto.getRelevel();

        if (num==0){ // 새글일 경우
            regroup=this.getMaxNum()+1;
            restep=0;
            relevel=0;

        } else { // 답글일 경우
            // 같은 그룹중에서 전달 받은 restep보다 큰 값의 경우 모두 일괄적으로 +1이 된다.
            this.updateRestep(regroup,restep);
            // 그리고 나서 전달받은 값보다 1크게 DB에 저장한다.
            restep++;
            relevel++;
        }
        // 변경된 값들을 다시 dto에 담는다.
        dto.setRegroup(regroup);
        dto.setRestep(restep);
        dto.setRelevel(relevel);

        mapperInter.insertReBoard(dto);

    }

    @Override
    public void updateRestep(int regroup, int restep) {
        Map<String, Integer> map=new HashMap<>();
        map.put("regroup",regroup);
        map.put("restep",restep);
        mapperInter.updateRestep(map);

    }

    @Override
    public void updateReadCount(int num) {
        mapperInter.updateReadCount(num);
    }

    @Override
    public ReBoardDto getData(int num) {
        return mapperInter.getData(num);
    }

    @Override
    public void updateReBoard(ReBoardDto dto) {
        mapperInter.updateReBoard(dto);
    }

    @Override
    public void deleteReBoard(int num) {
        mapperInter.deleteReBoard(num);
    }

    @Override
    public void updateLikes(int num) {
        mapperInter.updateLikes(num);
    }
}
