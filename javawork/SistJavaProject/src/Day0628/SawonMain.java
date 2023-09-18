package Day0628;

import java.util.Scanner;

public class SawonMain {

    public static void getSawon(Sawon[] sawon) {

        // 최종출력
        // 제목
        Sawon.getTitle();

        for(Sawon s:sawon) {
            System.out.println(s.getSawonName()+"\t"+s.getPay()+"\t"+s.getFamSu()+"\t"+s.getTimeSu()+"\t"+s.getFamilySudang()+"\t"+s.getTimeSudang()+"\t"+s.getTotalPay());
        }
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int inwon; // 몇명인지 입력

        Sawon [] sawon;

        System.out.println("입력할 직원수는 몇명입니까?");
        inwon=Integer.parseInt(sc.nextLine()); // 숫자 입력 후에 글자명이 올 예정이기 때문에 String을 입력하는 것으로 기본 잡고 형변환으로 숫자로 강제 변환 해줘야 한다.

        // 배열할당
        sawon=new Sawon[inwon];

        // 인원수만큼 데이터 입력
        for(int i=0;i<inwon;i++) {
            // sawon을 생성해줘야함. (명시적 생성자가 아니라, default 생성자이기 때문에)
            sawon[i]=new Sawon();

            System.out.println("사원명?");
            String name=sc.nextLine();
            System.out.println("급여?");
            int pay=Integer.parseInt(sc.nextLine());
            System.out.println("가족수?");
            int fs=Integer.parseInt(sc.nextLine());
            System.out.println("초과시간?");
            int ts=Integer.parseInt(sc.nextLine());

            // setter로 Sawon 클래스에 데이터 넣기
            sawon[i].setSawonName(name);
            sawon[i].setPay(pay);
            sawon[i].setFamSu(fs);
            sawon[i].setTimeSu(ts);

        }
        //출력
        getSawon(sawon);
    }
}
