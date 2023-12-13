import React, {useState} from 'react';

function WriteForm({onSave}) {

    const [name,setName]=useState();
    const [photo,setPhoto]=useState();
    const [blood,setBlood]=useState();

    // 부모에게서 받은 버튼 이벤트 생성
    const addDataEvent=()=>{
        // 부모 컴포넌트에서 만든 onSave를 호출만하면 된다.
        onSave({name,photo,blood});
    }

    return (
        <div>
            <b>이름:</b>
            <input type={"text"} style={{width:'100px'}} onChange={(e)=>{
                setName(e.target.value);
            }}/>
            <b>이미지:</b>
            <select onChange={(e)=>{
                setPhoto(e.target.value)
            }}>
                {
                    // 1~10 까지 map 으로 돌리기 s1~s10
                    [...new Array(10)].map((a,idx)=>(<option>{`${idx+1}`}</option>))
                }
            </select>

            <b>혈액형:</b>
            <select onChange={(e)=>{
                setBlood(e.target.value)
            }}>
                <option>A</option>
                <option>B</option>
                <option>O</option>
                <option>AB</option>
            </select>

            <button type={"button"} className={'btn btn-info'} style={{marginLeft:'10px'}} onClick={addDataEvent}>추가</button>
        </div>
    );
}

export default WriteForm;