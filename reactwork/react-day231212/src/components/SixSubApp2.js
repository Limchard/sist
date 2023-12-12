import React from 'react';

function SixSubApp2({flower,price,linecolor}) { // props 를 지우고, 직접 받을 수 있음.
    return (
        <div>
            <h3 className={'alert alert-danger'}>SixApp의 둘째입니다.</h3>
            <h3 className={'line'} style={{borderColor:linecolor}}>{flower} 1묶음 가격은 {price} 입니다.</h3>
        </div>
    );
}

export default SixSubApp2;