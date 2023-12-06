
let irum="limchard";
let birth=1993;
let likefood="gosu";

let curYear=new Date().getFullYear(); // 숫자 4자리 반환

// 예전 출력 방식
let result="이름: "+irum+"\n태어난 연도: "+birth+"\n나이: "+(curYear-birth)+"\n좋아하는 음식: "+likefood;
console.log(result);

// 템플릿,, 리터럴,, 백틱(`)

// 리터럴(백틱 ``).. 중간변수는 ${변수명}
let result2=`이름: ${irum}
태어난연도: ${birth}
나이: ${curYear-birth}
좋아하는 음식: ${likefood}`
console.log(result2);