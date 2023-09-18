package Day0628;

class MyShop{
    private String sangpumName;
    private String ipgoday;
    private String chulgodaty;

    // 3개의 데이터를 한번에 수정할수 있는 메서드
    public void setData(String name,String ip,String chul) {
        sangpumName = name;
        ipgoday = ip;
        chulgodaty = chul;
    }
//     3개의 데이터를 한번에 출력할수 있게 메서드
    public void getData() { // return 값은 String or int, 출력문은 void
        System.out.println("상품명: "+sangpumName+"\n입고일: "+ipgoday+"\n출고일: "+chulgodaty);
        }
//    public String getData() {
//        String s="상품명: "+sangpumName+"\t입고날짜: "+ipgoday+"\t출고일: "+chulgodaty;
//        return s;
//    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
public class QuizShop_05 {
    public static void main(String[] args) {
        MyShop in1=new MyShop();
        in1.setData("키보드","2023-06-01","2023-08-30");
        in1.getData();

        MyShop in2=new MyShop();
        in2.setData("마우스","2023-06-04","2023-10-23");
        in2.getData();

//        MyShop in3=new MyShop();
//        in3.setData("키보드","2023-06-01","2023-08-30");
//        System.out.println(in3.getData());
//
//        MyShop in4=new MyShop();
//        in4.setData("마우스","2023-06-04","2023-10-23");
//        in4.getData();
//        System.out.println(in4.getData());

    }
}
