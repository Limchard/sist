import React, {useEffect, useState} from 'react';
import {useNavigate} from "react-router-dom";
import axios from "axios";
import ShopRowItem from "./ShopRowItem";

function Shop(props) {

    const navi=useNavigate(); // 이동할 수 있는 메서드

    // 백엔드에서 받아올 list에 대한 데이터 변수
    const [shopList,setShopList]=useState([]);

    // 데이터를 가져오는 함수를 가져와야 한다.
    const list=()=>{

        let url="http://localhost:9100/shop/list";

        axios.get(url)
            .then(res=>{
                // 스프링으로부터 받아온 list를 shopList에 넣기
                setShopList(res.data);
                console.log("len: "+res.data.length); // 이걸 여기서 출력(확인)후 RowItem에서 출력 예정이다.
            })
    }

    // 처음 렌더링 시 딱 한번 데이터 가져오기
    useEffect(()=>{
        console.log("list: ");
        list();
    },[]); // 여기서 ,[] 안적으면 계속 생성되네?


    return (
        <div style={{marginLeft:'100px'}}>
            <button type={"button"} className={'btn btn-info'} style={{width:'120px'}} onClick={()=>{
                navi("/shop/form");
            }}>상품등록</button>
            <hr/>
            <table className={'table table-bordered'} style={{width:'500px'}}>
                <thead>
                <tr>
                    <th width={'60'}>번호</th>
                    <th width={'140'}>상품명</th>
                    <th width={'300'}>상세보기</th>
                    {/*<th width={'60'}>수량</th>*/}
                    {/*<th width={'60'}>단가</th>*/}
                    {/*<th width={'60'}>입고일</th>*/}
                </tr>
                </thead>
                <tbody>
                {
                    shopList.map((row,index)=>(
                        <ShopRowItem row={row} idx={index}/>
                        ))
                }
                </tbody>
            </table>
        </div>
    );
}

export default Shop;