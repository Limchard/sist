import React, {useState} from 'react';

function ThreeApp(props) {

    const [boards,setBoards]=useState([
        {
            no:1,
            writer:'뽀로로',
            subject:'영환이 보쏘',
            photo:'s1'
        },
        {
            no:2,
            writer:'피카츄',
            subject:'백만볼트',
            photo:'s2'
        },
        {
            no:3,
            writer:'라이츄',
            subject:'천만볼트',
            photo:'s3'
        },
        {
            no:4,
            writer:'토게피',
            subject:'몸통박치기',
            photo:'s4'
        },
        {
            no:5,
            writer:'마자용',
            subject:'맞아?',
            photo:'s5'
        }
    ]);

    return (
        <div style={{marginLeft:'100px'}}>
            <h3 className={'alert alert-info'}>ThreeApp입니다._객체배열 컴포넌트 배열안에 출력</h3>
            <table className={'table table-bordered'} style={{width:'600px'}}>
                <caption align={'top'}><b>배열객체출력</b></caption>
                <thead>
                    <tr>
                        <th width={'60'}>번호</th>
                        <th width={'100'}>사진</th>
                        <th width={'260'}>제목</th>
                        <th width={'100'}>작성자</th>
                    </tr>
                </thead>
                <tbody>
                {
                    boards.map((row,index)=>(<tr>
                        <td>{row.no}</td>
                        <td><img src={`../image2/${row.photo}.JPG`} style={{width:'50px'}}/></td>
                        <td>{row.subject}</td>
                        <td>{row.writer}</td>
                    </tr>))
                }
                </tbody>
            </table>

        </div>
    );
}

export default ThreeApp;
