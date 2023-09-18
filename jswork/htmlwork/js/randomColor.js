function randomColor(){
    // rgb 색상얻기
    var r=parseInt(Math.random()*256); // 0~ 255 까지
    var g=parseInt(Math.random()*256); // 0~ 255 까지
    var b=parseInt(Math.random()*256); // 0~ 255 까지
    var color="rgb("+r+","+g+","+b+")";
    return color;
}