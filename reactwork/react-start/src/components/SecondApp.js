import React from 'react';
import cat4 from '../image/6.jpg'

function SecondApp(props) {

    const catStyle={
        width:'200px',
        marginLeft:'30px'
    }

    let helloEle=<h2 className='alert alert-info'>Hello~~</h2>
    return (
        <div>
            <h2 className='alert alert-danger'>SecondApp 입니다.</h2>
            <img src='../image2/19.jpg' style={catStyle}/>
            <img src={cat4} style={catStyle}/>
            {helloEle}
            {helloEle}
            {helloEle}
            {helloEle}
            {helloEle}
        </div>
    );
}

export default SecondApp;