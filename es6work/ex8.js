// es6 좀더 언어적으로 바뀜, Set,Map 가능(컬렉션)
let set=new Set("abcccdddeeefffff"); // 중복문자 걸러낸다.
console.log(set);

set.add("g"); // 없으니까 추가 됨
console.log(set);

console.log(set.has("a")); // has : ~~를 포함하면 true, 없으면 false
console.log(set.has("n"));
console.log("길이: "+set.size);

console.log(...set);

set.delete("a"); // 하나씩 지우는 것.
// 다 지우는건 clear..

set.delete("a"); // 하나씩 지우는 것.

console.log(...set);

// 다 지우는건 clear..
set.clear(); // 전체 삭제 
console.log(set.size);

// 비교연산자
let a=6;
let b="6";

console.log(a==b); // true 값으로만 비교
console.log(a===b); // false 타입까지 같아야 true

