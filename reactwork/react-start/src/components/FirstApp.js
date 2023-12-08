import React from 'react';
import './MyStyle.css';
import cat1 from '../image/2.jpg';
import cat2 from '../image/3.jpg';
import cat3 from '../image/6.jpg';

function FirstApp(props) {

    // 스타일을 변수에 지정
    const styleImg1={
        width:'200px',
        border:'5px solid gray',
        marginLeft:'30px',
        marginTop:'20px'    
    }

    return (
        <div>
            {/* <h2 className='alert alert-warning'>FirstApp Component!!!</h2> */}
            <h2 className='line2'>FirstApp Component!!!</h2>
            <div style={{fontSize:'30px',marginLeft:'100px',backgroundColor:'salmon'}}>
                안녕~~ 오늘은 목요일이야!!
            </div>
            {/* src의 이미지는 import */}
            <img src={cat1} style={styleImg1}/>
            <img src={cat2} style={{width:'200px',border:'3px dotted pink',marginLeft:'20px'}}/>

            {/* public image는 직접 호출 가능합니다. */}
            
            <hr/>
            <h3> public image </h3>
            <img src='../image2/17.jpg' style={{width:'250px',marginLeft:'20px'}}/>
        </div>
    );
}
export default FirstApp;