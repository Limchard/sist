// 화살표 함수 -> 객체생성 못한다.(일반함수와의 차이점)
// 화살표 함수 : new생성안됨 
// 자바의 Ramda 익명함수와 같은 방식 (function 이라는 키워드를 안쓴다. 대신에 화살표를 사용한다.)

/*
// 일반함수 
function 함수명(){
    함수로직
}

// 익명함수
function (){
    함수로직
}

// 익명함수를 변수로 지정
const 변수=function (){
    함수로직
}

// 변수로 지정된 함수를 화살표함수로..
const 변수=()=>{
    함수로직
}

*/

function f1(){
    console.log("일반함수 f1");
}
f1();

// 화살표함수
let f2=()=>{ // 한줄일 경우 {} 생략 가능
    console.log("화살표함수 f2")
}
f2();

// 일반함수
function f3(a,b){
    return a+b;
}
let a=f3(5,7);
console.log(a);

// 화살표 함수
let f4=(a,b)=>a+b; // 한줄일 경우 {} 생략 가능, return도 생략 가능 
let b=f4(11,22);
console.log(b);

// 일반함수
function f5(x,y,z=100){
    return x+y+z;
}

console.log(f5(1,2,3));
console.log(f5(1,2));


// f5를 화살표 함수f6으로 구현 후 호출
let f6=(x,y,z=100)=>x+y+z;
let c=f6(22,33);
console.log(c);
console.log(f6(4,5));



