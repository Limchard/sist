let arr1=[2,4,6];
let arr2=[6,7];
let arr3=[11,12,...arr1,22,...arr2];

console.log(arr3.length);
console.log(arr3);
console.dir(arr3);

let arr4=[...[100,200],...arr2];
console.log(arr4);

function fsum(arr){
    let sum=0;

    // 방법 1
    // for(i=0;i<arr.length;i++){
    //     sum+=arr[i];
    // }

    // 방법2
    for(let a in arr){ // for~each 문이라고 생각하자.
        sum+=arr[a];
    }
    console.log("합계: "+sum);
}

fsum(arr3);

function func3(a,b,c,d,e){
    console.log(a,b,c,d,e);
}
func3(arr3);
func3(...arr3);


// ... : 펼침연산자. 흐트러진 배열을 가져올때 사용한다.