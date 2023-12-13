import React from 'react';

function SixSubApp3(props) {
    return (
        <div>
            <h3 className={'alert alert-danger'}>SixApp의 셋째입니다.</h3>
            <button className={'btn btn-danger'} onClick={props.incre}>증가</button> &nbsp;&nbsp;
            <button className={'btn btn-warning'} onClick={()=>{
                props.decre();
            }}>감소</button>

        </div>
    );
}

export default SixSubApp3;