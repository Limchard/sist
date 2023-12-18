import React, {useState} from 'react';
import axios from "axios";
import {useNavigate} from "react-router-dom";

function ShopForm(props) {

    // 변수선언
    const [photo,setPhoto]=useState();
    const [sangpum,setSangpum]=useState(); // DB명과 일치해야 합니다.
    const [su,setSu]=useState(); // DB명과 일치해야 합니다.
    const [dan,setDan]=useState(); // DB명과 일치해야 합니다.

    const navi=useNavigate(); // 인서트 후 목로으로 이동해야 하기에..

    // url 등록 (업로드 시에는 2개가 필요하다. upload 용과 save 폴더에 넣을꺼
    let uploadUrl="http://localhost:9100/shop/upload"; // 백엔드 매핑주소
    let photoUrl="http://localhost:9100/save/"; // save 폴더에 넣을꺼다. 이에 맞는 주소
    let insertUrl="http://localhost:9100/shop/insert"; // insertUrl

    // file change 시 호출하는 event
    const uploadImage=(e)=>{
        const uploadFile=e.target.files[0]; // 파일을 선택할때에는 항상 이런 방식으로 해야한다. 이게 원래 쓰던 'e.target.value'랑 같다.
        const imageFile=new FormData(); // 무조건 new 로 생성해줘야 한다. save 폴더에 넣을거
        imageFile.append("uploadFile",uploadFile);
        axios({
            method:'post',
            url:uploadUrl,
            data:imageFile,
            headers:{'Content-Type':'multipart/form-data'} // 원래 form 에서 해주던거 여기서 해줘야 한다.
        }).then(res=>{ // 성공했을 때
            setPhoto(res.data); // 백엔드에서 보낸 변경된 이미지명(sdf 포함된 이름)을 photo 변수에 넣는다.
        }).catch(err=>{ // 에러났을때
            alert(err); // 에러메시지
        })
    }

    // 추가하는 함수 이벤트.. 추가 후 이동
    const onInsert=()=>{
        // axios.post(insertUrl,{sangpum:sangpum}) // 원래는 json 형태로 입력해야 하지만... key와 value값이 같으면 아래와 같이 생략 가능
        axios.post(insertUrl,{sangpum,su,dan}).then(res=>{
            // insert 처리후 뭘 해야할까 하는 코드들..
            // 목록으로 이동
            navi("/shop/list");
        })
    }

    return (
        <div>
            <table className={'table table-bordered'} style={{width: '600px'}}>
                <caption align={'top'}><b>상품등록</b></caption>
                <tbody>
                <tr>
                    <th>상품명</th>
                    <td>
                        <input type={"text"} className={'form-control'} style={{width: '250px'}}
                               onChange={(e)=>{
                            setSangpum(e.target.value)
                        }}/>
                    </td>
                    <th>{sangpum}</th>
                </tr>
                <tr>
                    <th>상품사진</th>
                    <td>
                        <input type={"file"} className={'form-control'} style={{width: '250px'}}
                               onChange={uploadImage}/>
                    </td>
                    <th></th>
                </tr>
                <tr>
                    <th>수량</th>
                    <td>
                        <input type={"text"} className={'form-control'} style={{width: '250px'}}
                        onChange={(e)=>{
                            setSu(e.target.value)
                        }}/>
                    </td>
                    <th>{su}</th>
                </tr>
                <tr>
                    <th>단가</th>
                    <td>
                        <input type={"text"} className={'form-control'} style={{width: '250px'}}
                        onChange={(e)=>{
                            setDan(e.target.value);
                        }}/>
                    </td>
                    <th>{dan}</th>
                </tr>
                <tr>
                    <td colSpan={'2'}>
                        <img src={photoUrl+photo} style={{width: '120px', marginLeft: '150px'}}/>
                    </td>
                    <td>
                        <button type={"button"} className={"btn btn-info"}
                                style={{width:'100px',height:'100px',marginLeft:'30px',marginTop:'10px'}}
                        onClick={onInsert}>상품등록</button>
                    </td>

                </tr>
                </tbody>
            </table>
        </div>
    );
}

export default ShopForm;