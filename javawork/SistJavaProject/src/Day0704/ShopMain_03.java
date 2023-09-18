package Day0704;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
1. 상품입고     2. 상품 재고        9.종료
1
상품명? 바나나
수량? 10
가격은? 1000
1
상품명? 포도
수량? 20
가격은? 3000
2
번호      상품명     수량      가격      총가격
1       바나나     10개     1000원       10000원
 */
public class ShopMain_03 {

    List<Shop_03> list=new Vector<>();

    public void inputShop(){
        Scanner sc=new Scanner(System.in);

        String sangName;
        int su,dan;

        System.out.println("상품명? ");
        sangName=sc.nextLine();
        System.out.println("수량? ");
        su=Integer.parseInt(sc.nextLine());
        System.out.println("단가? ");
        dan=Integer.parseInt(sc.nextLine());

        Shop_03 data=new Shop_03();
        data.setSangName(sangName);
        data.setDan(dan);
        data.setSu(su);

        list.add(data);

        System.out.println("현재데이터 갯수: "+list.size());
    }

    public void writeShop(){

        System.out.println("번호\t상품명\t수량\t단가\t총가격");

        for(int i=0;i< list.size();i++){
            Shop_03 s=list.get(i);

            System.out.println(i+"\t"+s.getSangName()+"\t"+s.getSu()+"\t"+s.getDan()+"\t"+(s.getSu()*s.getDan()));
        }
    }


    public static void main(String[] args) {

        ShopMain_03 sh=new ShopMain_03();

        Scanner sc=new Scanner(System.in);

        int n;

        while(true){

            System.out.println("1.추가    2.전체출력     9.종료 ");
            n=Integer.parseInt(sc.nextLine());

            if(n==1){
                sh.inputShop();
            } else if (n==2) {
                sh.writeShop();
            } else if (n==9) {
                System.out.println("시스템 종료");
                break;
            } else {
                System.out.println("숫자를 잘못 입력했어요");
                continue;
            }
        }
    }
}
