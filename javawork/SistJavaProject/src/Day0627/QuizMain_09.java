package Day0627;

public class QuizMain_09 {

    public static void main(String[] args){

        // 생성 3번하여 불러오기.
        System.out.println("\t[쇼핑목록]");

        System.out.println("쇼핑장소:" +Quiz_09.SHOPNAME);
//-------------------------------------------------------------------------------------------
        Quiz_09 q1=new Quiz_09();
        q1.setSangName("손선풍기");
        q1.setPrice(25000);

        String sang=q1.getSangName();
        int pri=q1.getPrice();

        System.out.println("상품명: "+sang);
        System.out.println("가격: "+pri+"원");
//-------------------------------------------------------------------------------------------
        System.out.println("==============================");
        System.out.println("쇼핑장소:" +Quiz_09.SHOPNAME);

        Quiz_09 q2=new Quiz_09();
        q2.setSangName("핸드폰충전기");
        q2.setPrice(35000);

        System.out.println("상품명: "+q2.getSangName());
        System.out.println("가격: "+q2.getPrice());
//-------------------------------------------------------------------------------------------
        System.out.println("==============================");
        System.out.println("쇼핑장소:" +Quiz_09.SHOPNAME);

        Quiz_09 q3=new Quiz_09();
        q3.setSangName("이어폰");
        q3.setPrice(70000);

        System.out.println("상품명: "+q3.getSangName());
        System.out.println("가격: "+q3.getPrice());



    }
}
