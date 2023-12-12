import React, {useRef, useState} from 'react';

function FourApp(props) {

    // useRef : 변수를 관리하는 기능.
    // useState 와의 차이점: 값이 변경되어도 다시 렌더링 하지 않음.

    // 일반 state 변수
    const [count,setCount]=useState(0);

    // ref 선언하는 법
    const countRef=useRef(0);

    // state 변수 증가하는 함수
    const stateIncre=()=>{
        setCount(count+1);
    }

    // ref변수 증가하는 함수
    const refIncrer=()=>{
        countRef.current=countRef.current+1; // ref변수.current (정해진 변수.) 무조건 current를 써야 한다
        // 1 증가해서 다시 current
        console.log("countRef: "+countRef.current);
    }

    return (
        <div>
            <h3 className={'alert alert-primary'}>FourApp입니다._useRef</h3>
            <button type={"button"} className={'btn btn-outline-danger'} onClick={stateIncre}>state 변수 증가</button>
            <div className={'number'}>{count}</div>
            <button type={"button"} className={'btn btn-outline-warning'} onClick={refIncrer}>ref변수 증가</button>
            <div className={'number'}>{countRef.current}</div>
        </div>
    );
}

export default FourApp;