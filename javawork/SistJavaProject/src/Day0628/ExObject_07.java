package Day0628;
/* 중간고사 시험결과
학생명: 임형준
자바점수: 99
오라클점수: 88
html점수:56
==============================

 */
class Score{

    private String stuName;
    private int java;
    private int oracle;
    private int html;

    static final String TITLE="중간고사 시험결과";

    // 자동 setter,getter 불러오자.
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getOracle() {
        return oracle;
    }

    public void setOracle(int oracle) {
        this.oracle = oracle;
    }

    public int getHtml() {
        return html;
    }

    public void setHtml(int html) {
        this.html = html;
    }

    // 합계메서드
    public int getTot() {
        int t=java+oracle+html;
        return t;
    }

    // 평균메서드
    public double getAvg() {
        double a=getTot()/3.0;
        return a;
    }
}

public class ExObject_07 {
    public static void main(String[] args) {

        Score m1=new Score();
        m1.setStuName("임형준");
        m1.setJava(97);
        m1.setOracle(99);
        m1.setHtml(98);
        System.out.println("***"+Score.TITLE+"***");
        System.out.println("학생이름: "+m1.getStuName()+"\n자바점수: "+m1.getJava()+"\n오라클점수: "+m1.getOracle()+"\nHTML점수: "+m1.getHtml()+"\n합계점수: "+m1.getTot()+"\n평균점수: "+m1.getAvg());
        System.out.println("=====================================================");

        Score m2=new Score();
        m2.setStuName("이성신");
        m2.setJava(100);
        m2.setOracle(100);
        m2.setHtml(100);
        System.out.println("학생이름: "+m2.getStuName()+"\n자바점수: "+m2.getJava()+"\n오라클점수: "+m2.getOracle()+"\nHTML점수: "+m2.getHtml()+"\n합계점수: "+m2.getTot()+"\n평균점수: "+m2.getAvg());
        System.out.println("=====================================================");

        Score m3=new Score();
        m3.setStuName("진현규");
        m3.setJava(23);
        m3.setOracle(42);
        m3.setHtml(11);
        System.out.println("학생이름: "+m3.getStuName()+"\n자바점수: "+m3.getJava()+"\n오라클점수: "+m3.getOracle()+"\nHTML점수: "+m3.getHtml()+"\n합계점수: "+m3.getTot()+"\n평균점수: "+m3.getAvg());
        System.out.println("=====================================================");

        Score m4=new Score();
        m4.setStuName("최성현");
        m4.setJava(89);
        m4.setOracle(87);
        m4.setHtml(79);
        System.out.println("학생이름: "+m4.getStuName()+"\n자바점수: "+m4.getJava()+"\n오라클점수: "+m4.getOracle()+"\nHTML점수: "+m4.getHtml()+"\n합계점수: "+m4.getTot()+"\n평균점수: "+m4.getAvg());

    }
}
