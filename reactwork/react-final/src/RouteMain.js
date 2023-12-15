import React from 'react';
import {About, Info, Main, Menu, Title} from "./conponents";
import {Route, Routes} from "react-router-dom";
import Shop from "./shop/Shop";
import Board from "./board/Board";
import Member from "./member/Member";
import Login from "./login/Login";
import {ShopDetail, ShopForm} from "./shop"; // 인덱스를 만들어줘야 이렇게 보기좋게 가독성 좋게 표현된다. 굳이 안써도 되지만 가독성을 위해 index.js를 만들어준다.


function RouteMain(props) {
    return (
        <div>
            <div className={'title'}><Title/></div>
            <div className={'info'}><Info/></div>
            <div className={'menu'}><Menu/></div>
            <div className={'main'}>
                <Routes>
                    <Route path={'/'} element={<Main/>}/>

                    {/* Shop */}
                    <Route path={'/shop/list'} element={<Shop/>}/>
                    <Route path={'/shop/form'} element={<ShopForm/>}/>
                    <Route path={'/shop/detail/:num'} element={<ShopDetail/>}/>
                    {/* 디테일 페이지로 갈때 num을 파라메터값으로 넘기겠다. */}


                    <Route path={'/board/list'} element={<Board/>}/>
                    <Route path={'/member/form'} element={<Member/>}/>
                    <Route path={'/login'} element={<Login/>}/>
                    <Route path={'/about'} element={<About/>}/>
                    <Route path={'*'} element={
                        <div>
                            <h1>잘못된 주소 입니다. </h1>
                        </div>
                        }/>
                </Routes>
            </div>

        </div>
    );
}

export default RouteMain;