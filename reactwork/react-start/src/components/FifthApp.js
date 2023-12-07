import React, {useState} from 'react';

function FifthApp(props) {

    const [name,setName]=useState('');
    const [resultName,setResultName]=useState('');
    const [java,setJava]=useState(0);
    const [react,setReact]=useState(0);
    const [total,setTotal]=useState(0);
    const [avg,setAvg]=useState(0);



    return (
        <div>
            <h2 className='alert alert-danger' >FifthApp 입니다.</h2>
            <div className={'inp'}>
                이름: <input type={"text"} style={{width:"150px"}} onChange={(event)=>{
                    setName(event.target.value);

            }}/>
                <span style={{marginLeft:"10px"}}>{name}</span>
                <br/><br/>
                java점수: <input type={"text"} style={{width:"150px"}} onChange={(event)=>{
                setJava(event.target.value);
            }}/>
                <span style={{marginLeft:"10px"}}>{java}</span>
                <br/><br/>
                react점수: <input type={"text"} style={{width:"150px"}} onChange={(event)=>{
                setReact(event.target.value);
            }}/>
                <span style={{marginLeft:"10px"}}>{react}</span>
                <br/><br/>
                <button type={"button"} className={'btn btn-outline-info'} onClick={()=>{
                    // setTotal(parseInt({react})+parseInt({java}));
                    setResultName(name);
                    setTotal(parseInt(react)+parseInt(java));
                    setAvg((parseInt(react)+parseInt(java))/2);
                }}>결과보기</button>
            </div>
            <div className='result'>
                이름 : {resultName} <br/>
                총합 : {total} 점 <br/>
                평균 : {avg} 점
            </div>
        </div>
    );
}

export default FifthApp;