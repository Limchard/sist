import React from 'react';
import {useNavigate} from "react-router-dom";

// function ShopRowItem(props) {
function ShopRowItem({idx,row}) {

    let photoUrl="http://localhost:9100/save/"; // 이미지를 띄우기 위해서는 photoUrl이 필요하다.

    const navi=useNavigate();

    return (
        <tr>
            <td>{idx+1}</td>
            <td><b>{row.sangpum}<img src={photoUrl+row.photo} className={'small'}/></b></td>
            <td>
                <button className={'btn btn-outline-success'} onClick={()=>{
                    // navi("/shop/detail/"+row.num); // 원래 방법
                    navi(`/shop/detail/${row.num}`); // 백틱 사용
                }}>상세보기</button>
            </td>
        </tr>
    );
}

export default ShopRowItem;