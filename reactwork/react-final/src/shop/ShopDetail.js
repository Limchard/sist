import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';




function ShopDetail(props) {

    const {num}=useParams(); // 이게 전 페이지에서 넘겨준 num값 받아오는 것이다.
    const navi=useNavigate();

    // dto 들어올 변수 선언
    const [data,setData]=useState('');

    // url 등록
    let detailUrl="http://localhost:9100/shop/detail?num="+num; // detail page의 url
    let photoUrl="http://localhost:9100/save/"; // 이미지를 띄우기 위해서는 photoUrl이 필요하다.
    let deleteUrl="http://localhost:9100/shop/delete?num="+num;

    // 스프링으로부터 num에 해당하는 data 받기
    const onDataReceive=()=>{
        axios.get(detailUrl)
            .then(res=>{
                console.log(res.data.sangpum);
                setData(res.data);
            }).catch(err=>{
                alert(err);
                alert(err.data);
        })
    }

    // 처음 랜더링시에 위의 함수 호출
    useEffect(()=>{
        onDataReceive();
    },[]);



    // 삭제 다이얼로그 코드추가(mui)
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    // 삭제시 호출 될 함수
    const onDelete=()=>{
        console.log("delete");

        axios.delete(deleteUrl)
            .then(res=>{
                // 삭제 후 목록으로 이동
                navi("/shop/list");
            })

        handleClose();
    }


    return (
        <div>

            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                    {"Use Google's location service?"}
                </DialogTitle>
                <DialogContent>
                    <DialogContentText id="alert-dialog-description">
                        Let Google help apps determine location. This means sending anonymous
                        location data to Google, even when no apps are running.
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Disagree</Button>
                    <Button onClick={onDelete} autoFocus>
                        Agree
                    </Button>
                </DialogActions>
            </Dialog>


            {/*num 출력확인시 db에서 가져올 수 있음*/}
            {/*<h1>{num}</h1>*/}
            <table className='table table-bordered' style={{width:'500px'}}>
                <caption align='top'><b>상품상세보기</b></caption>
                <tbody>
                    <tr>
                        <td width={'350'} rowSpan={'4'}>
                            <img src={photoUrl+data.photo} className={'large'} />
                        </td>
                        <td>
                            <h4>상품명 : {data.sangpum}</h4>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4>수량 : {data.su}</h4>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4>단가 : {data.dan}</h4>
                        </td>
                    </tr>
                <tr>
                    <td>
                        <button type={'button'} className={'btn btn-outline-info'}
                                onClick={()=>{
                                    navi("/shop/list")
                                }}>목록</button>
                        <button type={'button'} className={'btn btn-outline-success'}
                                onClick={()=>{
                                    navi("/shop/form")
                                }}>추가</button>
                        <button type={'button'} className={'btn btn-outline-warning'}>수정</button>
                        <button type={'button'} className={'btn btn-outline-danger'}
                                onClick={handleClickOpen}>삭제</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>



    );
}

export default ShopDetail;