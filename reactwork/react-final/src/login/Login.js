import React from 'react';
import LoginForm from "./LoginForm";
import Logout from "./Logout";

function Login(props) {


    // localStorage 방법
    let loginok=localStorage.loginok;

    return (
        <div>
            {
                loginok==null?<LoginForm/>:<Logout/>
            }
        </div>
    );
}

export default Login;