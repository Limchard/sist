import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import axios from "axios";

function ShopDetail(props) {

    const {num}=useParams(); // 이게 전 페이지에서 넘겨준 num값 받아오는 것이다.

    // dto 들어올 변수 선언
    const [data,setData]=useState();

    // url 등록
    let detailUrl="http://localhost:9100/shop/detail?num="+num; // detail page의 url
    let photoUrl="http://localhost:9100/save/"; // 이미지를 띄우기 위해서는 photoUrl이 필요하다.

    // 스프링으로부터 num에 해당하는 data 받기
    const onDataReceive=()=>{
        axios.get(detailUrl)
            .then(res=>{
                console.log(res.data.sangpum);
                setData(res.data);
            }).catch(err=>{
                alert(err);
                alert(err.data);
        })
    }

    // 처음 랜더링시에 위의 함수 호출
    useEffect(()=>{
        onDataReceive();
    },[]);

    return (
        <div>
            <h1>{num}</h1>
        </div>
    );
}

export default ShopDetail;