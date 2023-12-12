import React, {useState} from 'react';
import SixSubApp from "./SixSubApp";
import SixSubApp2 from "./SixSubApp2";
import SixSubApp3 from "./SixSubApp3";

function SixApp(props) {

    const [number,setNumber]=useState(10);
    // 증가 이벤트
    const NumberIncre=()=>{
        setNumber(number+1);
    }
    // 감소 이벤트
    const NumberDecre=()=>{
        setNumber(number-1);
    }

    return (
        <div>
            <h3 className={'alert alert-dark'}>SixApp입니다._부모자식간 컴포넌트통신</h3>
            <SixSubApp name={'뽀로로'} age={'7'}/>
            <SixSubApp name={'포비'} age={'54'}/>
            <SixSubApp name={'루피'} age={'31'}/>
        {/*    자식은 연속적으로 여러개 호출도 가능하다. */}
        {/*  props 라는 변수로 name, age 전달 가능하다.  */}
            <br/><br/>
            <SixSubApp2 flower={"수국"} price={'25000'} linecolor={'purple'}/>
            <SixSubApp2 flower={"벚꽃"} price={'35000'} linecolor={'pink'}/>
            <SixSubApp2 flower={"장미"} price={'20000'} linecolor={'red'}/>
            <SixSubApp2 flower={"매화"} price={'50000'} linecolor={'yellow'}/>
            <SixSubApp2 flower={"안개꽃"} price={'10000'} linecolor={'tomatos'}/>
            <br/><br/>
            <div className={'number'}>{number}</div>
            <SixSubApp3 incre={NumberIncre} decre={NumberDecre}/>
        </div>
    );
}

export default SixApp;
