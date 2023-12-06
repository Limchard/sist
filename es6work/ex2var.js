// 
/*
var : 함수형 변수
let : 영역형 변수 (변수 재 선언 불가.) var a="김영환" var a="이민규" 이게 불가능.
const : 영역현 변수 (주로 상수, final 같은거에 사용)
*/


// var Test : 재선언가능, 업데이트 가능
var hello="안녕";
var hello="헬로우";
var cnt=5;

if(cnt<6){
    var hello1="say hello~~";
    console.log(hello1);
}
// if(cnt>6){
//     var hello1="say hello~~";
//     console.log(hello1);
// }

console.log(hello1);
console.log(hello);

// let Test .. 재선언 불가능, 업데이트 가능

let hi="hi";
hi="하이라고 할께";

let times=5;
if(times>3){
    let hi1="say Hi~~~";
    console.log(hi1);
}
// console.log(hi1);
console.log(hi);


// const : 업데이트 불가능, 재선언 불가능
const hi3="안녕";
// hi3="하이";

const hi4={
    message:"4th say Hi~~~",
    times:4
}
console.log(hi4);

hi4.message="이렇게는 될까?";

console.log(hi4);

hi4.times=44;
console.log(hi4);


