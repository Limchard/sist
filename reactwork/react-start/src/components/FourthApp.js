import React, { useState } from 'react';
import cat from '../image/3.jpg'

function FourthApp(props) {

    const [name,setName]=useState('뽀로로');
    const [age,setAge]=useState('22');

    return (
        <div>
            <h3 className='alert alert-danger'>FourthApp 입니다.
                <img className='rounded-circle' src={cat} style={{width:'200px',marginLeft:'50px'}}/>
            </h3>
            <br/>
            <b style={{fontSize:'30px'}}>이름:{name} &nbsp;&nbsp; <span style={{marginLeft:'20px'}}>나이: {age}세</span></b>
            <br/>
            <button type='button' className='btn btn-info' onClick={()=>{
                setName("리처드");
                setAge(25);
            }}>값변경</button>
            <button type='button' className='btn btn-danger' style={{marginLeft:"20px"}}
            onClick={()=>{
                setName("");
                setAge('');
            }}>초기화</button>
        </div>
    );
}

export default FourthApp;