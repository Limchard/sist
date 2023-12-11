const array=[1,2,3,4,5]; // 3을 제거하고 싶어요.
// const delIndex=2;


// splice
array.splice(2,1); // 삭제할 인덱스 번호, 갯수 삭제
console.log(array);

// slice
// slice는 원본 배열은 건드리지 않고, 수정된복사 배열값을 리턴한다.(교체는 안된다)
var array2=[1,2,3,4,5];
// 3,4 를 뽑아 출력한다.
var a2=array2.slice(2,4); // 시작인덱스, 마지막인덱스-1
// 내가 원하는 숫자보다 +1을 해서 괄호에 적는다.
// 괄호의 숫자에서 -1이 뽑힌다.
console.log(a2);
var a3=array2.slice(2,5);
console.log(a3);
var a4=array2.slice(1,4);
console.log(a4);

// Arrays.concat(value); // 값 추가.
// concat 메서드는 원하는값을 원본 배열의 끝에 추가한 다음, 새로운 배열을 만든다.
let con=[1,2,3,4,5].concat([6,7],[7,8]);
console.log(con);

// filter
var arr=[1,2,3,4,5]; // 2를 제거하고 싶다.
console.log(arr);
var delInx=1; // 2의 인데스는 1이다.

arr=arr.filter(function (item,index){ // filter안에 인자로 함수를 받고, index만 필요하니까 명시해준다.
    return index!==delInx; // 배열을 돌면서 index 1이 아닌 나머지만 다시 소집한다.
})
console.log(arr);
