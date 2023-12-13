import React from 'react';

// function RowItemApp({row,idx,onDelete}) {
function RowItemApp(props) {

    let {row,idx,onDelete}=props; //

    // 삭제이벤트
    const btnDelete=()=>{
        onDelete(idx); // 부모가 props로 보낸 이벤트 호출하는 것.
    }

    return (
        <tr>
            <td>{row.name}</td>
            <td><img src={`../image/s${row.photo}.JPG`} style={{width:'100px',border:'1px solid gray'}}/></td>
            <td>{row.blood}형</td>
            <td>{row.today.toLocaleString('ko-kr')}</td>
            {/*<td>{row.today.toDateString()}</td>*/}
            <td>
                <button type={"button"} className={'btn btn-outline-danger btn-sm'} onClick={btnDelete} >삭제</button>
            </td>

        </tr>
    );
}

export default RowItemApp;