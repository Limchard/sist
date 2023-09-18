package data.dto;

public class CourseDto {

	private String seq;
	private String id;
	private String tour_seq;
	private String name;
	private String day;
	private String trun;
	private String intro;
	private String mainphoto;
	
	public String getSeq() {
		return seq;
	}
	public String getTrun() {
		return trun;
	}
	public void setTrun(String trun) {
		this.trun = trun;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTour_seq() {
		return tour_seq;
	}
	public void setTour_seq(String tour_seq) {
		this.tour_seq = tour_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getMainphoto() {
		return mainphoto;
	}
	public void setMainphoto(String mainphoto) {
		this.mainphoto = mainphoto;
	}

}
