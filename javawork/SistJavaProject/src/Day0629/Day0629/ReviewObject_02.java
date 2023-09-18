package Day0629.Day0629;
/*
나는 스타벅스 코엑스매장에 왔습니다.
아이스 아메리카노를 주문합니다.
우산을 샀네요
 */

class Starbucks{

    private String menu; // 메뉴
    private String store; // 지점
    private String goods; // 굿즈 텀블러 등등...

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }
}

////////////////////////////////////////////////////////
public class ReviewObject_02 {

    public static void main(String[] args) {

        Starbucks sb=new Starbucks();
        sb.setStore("코엑스매장");
        sb.setMenu("아이스 아메리카노");
        sb.setGoods("우산");

        String s=sb.getStore();
        String m=sb.getMenu();
        String g=sb.getGoods();

        System.out.println("나는 스타벅스 "+s+"에 왔습니다.");
        System.out.println(m+"를 주문합니다.");
        System.out.println(g+"을 샀어요");

    }
}
