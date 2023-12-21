import React, {useEffect, useState} from 'react';
import axios from "axios";

function Logout(props) {

    const [name,setName]=useState('');
    let id=localStorage.myid;

    const initFunc=()=>{
        const initUrl="http://localhost:9100/member/getname?id="+id;
        axios.get(initUrl)
            .then(res=>{
                setName(res.data);
            })
    }

    const btnLogout=()=>{
        localStorage.removeItem("loginok");
        localStorage.removeItem("myid");
        window.location.reload(); // 새로고침
    }

    useEffect(()=>{
        initFunc(); // 처음 랜더링시 한번만 호출
    },[])

    return (
        <div>
            <b style={{marginLeft:'100px'}}>{name}님 로그인 하셨습니다.</b>
            <button type={"button"} className={'btn btn-outline-danger'} style={{marginLeft:'30px'}}
            onClick={btnLogout}>로그아웃</button>
        </div>
    );
}

export default Logout;