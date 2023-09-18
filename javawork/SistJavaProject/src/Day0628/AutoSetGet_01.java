package day0628;

class MyDate{

    //instance 변수
    private int year;
    private int month;
    private int day;

    //디폴트 생성자 숨어있다..명시적 생성자 만들면 생성
    //자동완성 할때 reference변수 앞에만 쓰고 자동완성 constructor로 하면 자동 완성 가능
    public MyDate() {
    }

    //명시적생성자...3개의 인자값을 수정과 동시에 생성하는 생성자
    //이것만 저장하면 오류가 뜨기 때문에 위 디폴트 생성자를 만들어줘서 오류를 없앰
    public MyDate(int y, int m, int d) {

        year=y;
        month=m;
        day=d;
    }

    // cmd+n 눌러서 자동입력 가능
    // getter,setter
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

}


////////////////////////////////////////////////
public class AutoSetGet_01 {

    public static void main(String[] args) {

        //객체생성
        //이 형식을 더 많이 쓴다
        MyDate date=new MyDate();

        date.setYear(2023);
        date.setMonth(6);
        date.setDay(22);

        System.out.println(date.getYear()+"-"+date.getMonth()+"-"+date.getDay());

        //명시적생성
        MyDate date1=new MyDate(2020, 8, 10);
        System.out.println(date1.getYear()+"-"+date1.getMonth()+"-"+date1.getDay());

    }

}
