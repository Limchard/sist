package spring.anno.ex4;

import org.springframework.stereotype.Component;

@Component // 자동으로 bean에 등록이 된다. (id는 클래스명이된다. 단,첫글자만 소문자로 바뀐다. 즉, myDao가 id가 된다.)
public class MyDao implements DaoInter {

	@Override
	public void insertData(String str) {
		// TODO Auto-generated method stub
		System.out.println(str+"_str데이터를 db에 추가 성공!!!");
	}

	@Override
	public void deleteData(String num) {
		// TODO Auto-generated method stub
		System.out.println(num+"num에 해당하는 데이터를 삭제 성공!~");

	}

}
