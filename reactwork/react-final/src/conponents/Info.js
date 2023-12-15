import React from 'react';
import infoimg from '../image/s1.JPG';

function Info(props) {
    return (
        <div>
            <img src={infoimg} style={{width:'100px'}}/>
            <br/><br/>
            <div>쌍용교육센터</div>
            <div>02-1111-2222</div>
        </div>
    );
}

export default Info;