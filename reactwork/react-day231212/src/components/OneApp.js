import React, {useEffect, useState} from 'react';

function OneApp(props) {

    const [name,setName]=useState('뽀로로');
    const [addr,setAddr]=useState('남극');

    // 랜더링 오류날 경우 그 이유를 찾을 때 사용하는 경우가 많다.
    // useEffect : 값 입력시 계속해서 랜더링되며 호출될 수도 있고, 생성자처럼 딱 한번 호출 되기도 한다.
    useEffect(()=>{
       console.log("state변수가 값 변경 시 마다 호출이 된다.");
    });
    // 오류가 나면..
    useEffect(()=>{
        console.log("처음랜더링 시 한번만 호출한다. 마치 생성자처럼..");
    },[]);

    useEffect(()=>{
        console.log("이름 변경시에만 호출하고 싶어");
    },[name]);

    return (
        <div>
            <h3 className={'alert alert-danger'}>OneApp입니다._useEffect</h3>
            <h3>이름: <input type={"text"} className={'form form-control'} defaultValue={name} style={{width:'200px',display:'inline-flex'}}
            onChange={(e)=>{
                setName(e.target.value);
            }}/></h3>
            <h3>주소: <input type={"text"} className={'form form-control'} defaultValue={addr} style={{width:'200px',display:'inline-flex'}}
            onChange={(e)=>{
                setAddr(e.target.value);
            }}/></h3>
            <hr/>
            <h2>이름: {name} </h2>
            <h2>주소: {addr} </h2>
        </div>
    );
}

export default OneApp;
