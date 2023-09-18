package Day0627;

public class Quiz_10 {
/* ** 상품입고 **
---------------------------------
    입고된 상점: 롯데마트
---------------------------------
    상품명: 딸기
    가격: 10000원
    수량: 5팩
---------------------------------
    상품명: 쵸코파이
    가격: 5000원
    수량: 10 상자
---------------------------------
    상품명: 요거트
    가격: 2500원
    수량: 100팩
 */

    //멤버변수선언
    private String sangpum; // 상품명
    int su; //수량
    int dan; // 단가
    static String SHOPNAME; // 상점

    // set 메서드
    public void setSangpum(String sangpum){   // public void setSangpum(종류 이름) => 이름은 아무거나해도 상관 없다. main에서 실행 시 아무 지장 없다.
        this.sangpum=sangpum;  //
    }
    public void setDan(int dan){
        this.dan=dan;
    }
    public void setSu(int su){
        this.su=su;
    }

    // get 메서드
    public String getSangpum(){
        return sangpum;
    }
    public int getDan(){
        return dan;
    }
    public int getSu(){
        return su;
    }

}
