import React, {useState} from 'react';
import {useNavigate} from "react-router-dom";
import axios from "axios";

function LoginForm(props) {
    const [id,setId]=useState('');
    const [pass,setPass]=useState('');
    const navi=useNavigate();



    const onLogin=(e)=>{
        e.preventDefault();
        const loginUrl="http://localhost:9100/member/login";

        axios.post(loginUrl,{id,pass})
            .then(res=>{
                console.log(res.data);
                if (res.data===0){
                    alert("아이디 또는 비밀번호가 맞지 않습니다.")
                } else {
                    localStorage.loginok="yes";
                    localStorage.myid=id;
                    window.location.reload(); // 새로고침
                }
            })
    }

    return (
        <div>
            <form onSubmit={onLogin}>
                <table className='table table-bordered' style={{width:'300px'}}>
                    <caption align='top'><b>회원로그인</b></caption>
                    <tr>
                        <td>
                            <input type='text' placeholder='ID' style={{width:'180px'}} className='form-control' required
                                   onChange={(e)=>{
                                       setId(e.target.value);
                                   }}/>
                        </td>
                        <td rowSpan={2}>
                            <button type='submit' className='btn btn-outline-info' style={{width:'100px',height:'100px'}}>LOGIN</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type='password' placeholder='PASSWORD' style={{width:'180px'}} className='form-control' required
                                   onChange={(e)=>{
                                       setPass(e.target.value);
                                   }}/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    );
}

export default LoginForm;