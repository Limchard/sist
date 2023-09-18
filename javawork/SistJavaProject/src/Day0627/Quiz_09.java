package Day0627;
/* 문제 :

멤버는 private, 디폴트 생성자
[쇼핑 목록]

쇼핑장소:이마트
상품명:선풍기
가격:25000원

쇼핑장소:이마트
상품명:핸드폰 충전기
가격:30000원

쇼핑장소:이마트
상품명:이어폰
가격:70000원

 */
public class Quiz_09 {

    //변수선언
    static String SHOPNAME="이마트";
    private String sangName;//null
    private int price; //0

    //set메서드
    public void setSangName(String name) {
        sangName=name;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    //get메서드
    public String getSangName() {
        return sangName;
    }

    public int getPrice() {
        return price;
    }

}


