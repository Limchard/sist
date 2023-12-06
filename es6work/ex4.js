
// 함수 파라메타 기본값 담기
function func1(x,y=200,z=300){
    console.log(x,y,z);
}

func1();
func1(3,4,5);
func1(100);
func1(3,4);
func1();

function func2(a,b){
    return a+b;
}
console.log(func2(5,6));

let arr=[3,5,9];
let r2=func2(arr[0],arr[1]);
console.log(r2); // 8 //3+5

// ... : ex6에서 추가된 기능.. 펼침 연산자
func1(...arr); // 배열 안에 값들을 다 불러줌
func1(arr[0],arr[1],arr[2]); // 위의 ...arr 과 같음

func1(arr); // 빈값 x 자리에 arr 배열이 통으로 들어감

let r3=func2(...arr); // 함수인자 갯수와 배열 갯수가 맞는 것 까지만 나옴 3,5,9 에서 3,5 만 들어감
console.log(r3);


