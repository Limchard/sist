import React, {useState} from 'react';
import Stack from "@mui/material/Stack";
import Alert from "@mui/material/Alert";
import AutoAwesomeIcon from '@mui/icons-material/AutoAwesome';
import RowItemApp from "./RowItemApp";
import WriteForm from "./WriteForm";

function OneApp(props) {

    // 객체변수화
    const [board,setBoard]=useState([
        {
            name:'유재석',
            photo:'1',
            blood:'A',
            today:new Date()
        },
        {
            name:'강호동',
            photo:'2',
            blood:'B',
            today:new Date()
        },
        {
            name:'하하',
            photo:'3',
            blood:'O',
            today:new Date()
        },
        {
            name:'지석진',
            photo:'4',
            blood:'O',
            today:new Date()
        },
        {
            name:'박명수',
            photo:'5',
            blood:'AB',
            today:new Date()
        },
    ]);

    // 데이터 추가하는 함수 이벤트
    // board를 바꾸면 렌더링이 되면서 추가된다.
    const datasave=(data)=>{
        setBoard(board.concat({
            // name: data.name,
            // photo: data.photo,
            // blood: data.blood,
            ...data,
            today: new Date()
        }))
    }

    // 삭제 이벤트
    const dataDelete=(idx)=>{
        setBoard(board.filter((item,i)=>(i!==idx))); // i가 idx 값과 다른 값만 취합한다. 그래서 setBoard에 다시 렌더링한다.
    }

    return (
        <div style={{marginLeft:'100px'}}>
            <Stack sx={{ width: '100%' }} spacing={2}>
                <Alert severity="info">OneApp<AutoAwesomeIcon/></Alert>
                <WriteForm onSave={datasave}/>

                <table className={'table table-bordered'} style={{width:'600px'}}>
                    <caption align={'top'}><b>Board 배열 출력 연습</b></caption>
                    <thead>
                        <tr className={'table-success'}>
                            <th width={'100'}>이름</th>
                            <th width={'120'}>사진</th>
                            <th width={'80'}>혈액형</th>
                            <th width={'160'}>날짜</th>
                            <th width={'70'}>삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        // 데이터 개수만큼 호출된다... 출력은 아직 안됨... 출력은 RowItemApp.js 에서 해야한다.
                        board.map((row,index)=>(<RowItemApp row={row} idx={index} onDelete={dataDelete} />)) // index 값을 무조건 넘겨줘야 기준점을 잡고 삭제 가능하다.
                    }
                    </tbody>
                </table>
            </Stack>
        </div>
    );
}

export default OneApp;