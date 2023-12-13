import React, {useState} from 'react';
import Alert from '@mui/material/Alert';
import Brightness2Icon from '@mui/icons-material/Brightness2';
import TwoSubApp from "./TwoSubApp";

function TwoApp(props) {

    const [color,setColor]=useState('pink');
    const [message,setMessage]=useState('오늘은 수요일^^');
    const [photo,setPhoto]=useState('s7');

    // 3개의 이벤트를 만들어 전달
    const changeMessage=(msg)=>{
        setMessage(msg);
    }
    const changeColor=(color)=>{
        setColor(color);
    }
    const changeImage=(img)=>{
        setPhoto(img);
    }

    return (
        <div>
            <Alert severity="success">TweApp<Brightness2Icon/></Alert>
            <br/>
            <h1 style={{color:color}}>{message}</h1>
            <img src={`../image/${photo}.JPG`} style={{width:'100px'}}/>
            <br/>
            <TwoSubApp onMessage={changeMessage} onColor={changeColor} onPhoto={changeImage}/>
        </div>
    );
}

export default TwoApp;