package answer.data;

import java.util.List;

public interface AnswerDaoInter {

	public void insertAnswer(AnswerDto adto);
	public List<AnswerDto> getAnswerList(int num);
	public int checkPassAnswer(int idx,String pass);
	public void deleteAnswer(int idx);
	
}
