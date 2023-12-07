import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import FirstApp from './components/FirstApp';
import SecondApp from './components/SecondApp';
import ThirdApp from './components/ThirdApp';
import FourthApp from './components/FourthApp';
import FifthApp from "./components/FifthApp";

// const root = ReactDOM.createRoot(document.getElementById('root')); root라는 곳을 찾아보자 public 폴더의 index.html에 있다. 즉, 결국 디자인은 html 파일에서 기입하고. idnex.js에서 import 받아서 한번에 출력하는 것이다.
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <App /> */}
    {/* <App /> 주석처리 하면 화면 안나온다. export한 것을 받아와서 결국 화면에 띄워주는 곳은  여기이다. */}
    {/* <FirstApp/> */}
    {/* <SecondApp></SecondApp> */}
    {/*<ThirdApp/>*/}
    {/*<FourthApp/>*/}
      <FifthApp/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
