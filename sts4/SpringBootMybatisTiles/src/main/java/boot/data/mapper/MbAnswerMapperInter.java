package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.MbAnswerDto;

@Mapper
public interface MbAnswerMapperInter {
	
	public void insertMbAnswer(MbAnswerDto dto);
	public List<MbAnswerDto> getAllAnswers(String num);
	public MbAnswerDto getAnswer(String idx);
	public void updateMbAnswer(MbAnswerDto dto);
	public void deleteMbAnswer(String idx);
	
	
}
