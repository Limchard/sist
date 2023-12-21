import React, {useEffect, useState} from 'react';
import axios from "axios";

function MemberList(props) {

    // 리스트 배열선언
    const [memList,setMemList]=useState([]);

    // 리스트 스프링에서 가져오기
    const getList=()=>{
        const listUrl="http://localhost:9100/member/list";
        axios.get(listUrl)
            .then(res=> {
                setMemList(res.data);
                console.log(memList.length);
            })

    }

    useEffect(()=>{
        getList();
    },[]);

    // db 삭제
    const onDataDelete=(num)=>{
        const deleteUrl="http://localhost:9100/member/delete?num="+num;
        axios.delete(deleteUrl)
            .then(res=>{
                alert("삭제성공!!")
                getList();
            })
    }


    return (
        <div style={{marginLeft:'100px'}}>
            <table className={'table table-bordered'} style={{width:'800px'}}>
                <caption align={'top'}><b>전체 회원 명단</b></caption>
                <thead>
                <tr className={'table-info'}>
                    <th width={'60'}>번호</th>
                    <th width={'120'}>회원명</th>
                    <th width={'120'}>아이디</th>
                    <th width={'160'}>연락처</th>
                    <th width={'200'}>이메일</th>
                </tr>
                </thead>
                <tbody>
                {
                    memList.map((row,index)=>(

                        <tr key={index}>
                            <td>{index+1}</td>
                            <td>{row.name}</td>
                            <td>{row.id}</td>
                            <td>{row.hp}</td>
                            <td>{row.email}</td>
                            <button type={"button"} className={'btn btn-danger'}
                            onClick={()=>{
                                onDataDelete(row.num)
                            }}>삭제</button>
                        </tr>

                    ))
                }
                </tbody>
            </table>
        </div>
    );
}

export default MemberList;