package Day0629.Day0629;
/*
*** tv 시청 목록 ***
* 채널 : ebs 채널을 시청 합니다.
* 볼륨 : 15 데시벨 입니다.
* ------------------------
* 채널 : tvN 채널을 시청합니다.
* 볼륨 : 22 데시벨 입니다.


 */
class MyTv{
    private String cha ; // 채널
    private String vol; // 볼륨

    public String getCha() {
        return cha;
    }

    public void setCha(String cha) {
        this.cha = cha;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }
}

//////////////////////////////////////////////////////////////////
public class ReviewObject_01 {

    public static void main(String[] args) {

//        System.out.println("** tv 시청 목록 **");
//
//        MyTv t1=new MyTv();
//        t1.setCha("ebs");
//        t1.setVol("15");
//        System.out.println("채널: "+t1.getCha()+"를 시청 합니다.");
//        System.out.println("볼륨: "+t1.getVol()+"데시벨 입니다.");
//
//        System.out.println("---------------------");
//
//        MyTv t2=new MyTv();
//        t2.setCha("tvN");
//        t2.setVol("22");
//        System.out.println("채널: "+t2.getCha()+"를 시청 합니다.");
//        System.out.println("볼륨: "+t2.getVol()+"데시벨 입니다.");

        // 선생님 풀이
        MyTv tv=new MyTv();

        tv.setCha("ebs");
        tv.setVol("15");
        String c=tv.getCha();
        String v=tv.getVol();
        System.out.println(c+"채널을 시청합니다.");
        System.out.println("볼륨은 "+v+"데시벨 입니다.");

        System.out.println("---------------------");

        MyTv tv1=new MyTv();

        tv1.setCha("ebs");
        tv1.setVol("15");
        String c1=tv1.getCha();
        String v1=tv1.getVol();
        System.out.println(c+"채널을 시청합니다.");
        System.out.println("볼륨은 "+v+"데시벨 입니다.");

    }
}
