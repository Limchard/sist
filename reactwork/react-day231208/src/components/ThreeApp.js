import React, {useState} from 'react';
import cat1 from '../image/21.jpg';
import cat2 from '../image/20.jpg';
import cat3 from '../image/19.jpg';
import cat4 from '../image/18.jpg';
import cat5 from '../image/17.jpg';

function ThreeApp(props) {

    const [hp1,setHp1]=useState('02');
    const [hp2,setHp2]=useState('0000');
    const [hp3,setHp3]=useState('0000');
    const [photo,setPhoto]=useState();
    const changeHp1=(e)=>{
        setHp1(e.target.value);
    }
    const changeHp2=(e)=>{
        setHp2(e.target.value);
    }
    const changeHp3=(e)=>{
        setHp3(e.target.value);
    }
    const changePhoto=(e)=>{
        setPhoto(Number(e.target.value));
       
    }
    return (
        <div>
            <h3 className='alert alert-warning'>ThreeApp입니다.</h3>
            <div className={'d-inline-flex'}>
                <select style={{width:'100px'}} className={'form-control'} onChange={changeHp1}>
                    <option defaultChecked>010</option>
                    <option>02</option>
                    <option>031</option>
                    <option>042</option>
                    <option>051</option>
                    <option>061</option>
                </select>
                &nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
                <input type={"text"} maxLength={4} className={'form-control'}
                       style={{width:'120px'}} placeholder={'0000'} onKeyUp={changeHp2}/>
                {/*onChange 대신해서 onKeyUp, onKeyDown 도 가능하다.*/}
                &nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
                <input type={"text"} maxLength={4} className={'form-control'}
                       style={{width:'120px'}} placeholder={'0000'} onKeyDown={changeHp3}/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <b>이미지 선택 :</b>&nbsp;&nbsp;
                <select className={'form-control'} style={{width:'100px'}} onChange={changePhoto}>
                    <option value={'1'}>이미지1</option>
                    <option value={'2'}>이미지2</option>
                    <option value={'3'}>이미지3</option>
                    <option value={'4'}>이미지4</option>
                    <option value={'5'}>이미지5</option>
                </select>
            </div>
            <br/><br/>
            <hr/>
            <h1>{hp1}-{hp2}-{hp3}</h1>
            <img src={photo===1?cat1:photo===2?cat2:photo===3?cat3:photo===4?cat4:cat5}/>

        </div>
    );
}

export default ThreeApp;