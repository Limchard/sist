// es6 에서는 class 기능이 추가가 됐다.


class Student{

    // 생성자.. 무조건 클래스명이 constructor
    constructor(name){
        this.name=name;
    }

    // 멤버함수
    // showName(){
    //     console.log("내이름은 "+this.name+"입니다.");
    // }
    
    showName(){
        console.log(`내이름은 ${this.name} 입니다.`);
    }
    
}
let s1=new Student("limchard");
console.log("이름: "+s1.name);
s1.showName();

let s2=new Student("hoihoi");
console.log(`이름: ${s2.name}`);
s2.showName();