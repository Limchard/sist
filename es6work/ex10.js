// 배열연습
var numbers=[1,2,3,4,5];

var process=numbers.map(function (num){
    return num*num;
});

console.log(process);

var colors=['red','pink','yellow','gray','blue'];

console.log(colors);
colors.map((color,index)=>{
    console.log(color,index);
})