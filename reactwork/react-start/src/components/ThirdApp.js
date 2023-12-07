import React, { useState } from 'react';
// useState : 훅스의 기본 기능? 이건 검색이 좀 필요하겠다..
function ThirdApp(props) {

    // 상태관리를 위한 변수설정 
    const [message,setMessage]=useState('기본값');

    // 엔터 이벤트 함수
    const enterEvent=(e)=>{
        if(e.key==='Enter'){
            setMessage('');
            e.target.value='';
        }
    }
    // const enterEvent=(e)=>{
    //     if(e.keyCode===13){
    //         setMessage('');
    //         e.target.value='';
    //     }
    // }

    

    return (
        <div>
            <h3 className='alert alert-dark'>ThirdApp 입니다.</h3>
            <h3 style={{color:'red'}}>{message}</h3>
            <h4>메시지를 입력해 주세요</h4>
            <input className='form-control' type='text'
            style={{width:'300px',fontSize:'2em'}} defaultValue={message} 
            onChange={(e)=>{
                console.log(e.target.value);
                // message 변수에 입력값 넣기
                setMessage(e.target.value);
            }}
            onKeyUp={enterEvent}
            />
        </div>
    );
}

export default ThirdApp;