package spring.mvc.json;

public class PhotoDto {

	private String name;
	private String photo;
	
	// 생성과 동시에 진행하기 위해? 한거라고? 어 음..그래요.. 뭔말인지 모르겠다...
	// JsonTestController.java 에서 List<> 에 값을 json처럼 쌍으로 넣기 위해서 호출한 것으로 파악됩니다.
	// 이게 없으면 각 값별로 배열 안에 dto.setName, dto,setPhoto 를 해줘야 되기 때문이다.
	public PhotoDto(String name,String photo) {
		super();
		this.name=name;
		this.photo=photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
		
}
