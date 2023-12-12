import logo from './logo.svg';
import './App.css';
import OneApp from "./components/OneApp";
import {useState} from "react";
import TwoApp from "./components/TwoApp";
import ThreeApp from "./components/ThreeApp";
import FourApp from "./components/FourApp";
import SixApp from "./components/SixApp";
import SevenApp from "./components/SevenApp";
import FiveApp from "./components/FiveApp";

function App() {

    const [idx,setIdx]=useState(1);

    const selectComponent = (event) => {
      setIdx(Number(event.target.value));
    }

  return (
    <div className="App">
      <div style={{fontSize:'20px'}}>
        <label>
          <input type={"radio"} name={'Comp'} defaultChecked defaultValue={'1'} onClick={selectComponent}/> OneApp
        </label> &nbsp;
          <label>
              <input type={"radio"} name={'Comp'} defaultValue={'2'} onClick={selectComponent}/> TwoApp
          </label> &nbsp;
          <label>
              <input type={"radio"} name={'Comp'} defaultValue={'3'} onClick={selectComponent}/> ThreeApp
          </label> &nbsp;
          <label>
              <input type={"radio"} name={'Comp'} defaultValue={'4'} onClick={selectComponent}/> FourApp
          </label> &nbsp;
          <label>
              <input type={"radio"} name={'Comp'} defaultValue={'5'} onClick={selectComponent}/> FiveApp
          </label> &nbsp;
          <label>
              <input type={"radio"} name={'Comp'} defaultValue={'6'} onClick={selectComponent}/> SixApp
          </label> &nbsp;
          <label>
              <input type={"radio"} name={'Comp'} defaultValue={'7'} onClick={selectComponent}/> SevenApp
          </label> &nbsp;
      </div>
        <hr/>
        {idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>:idx===4?<FourApp/>:idx===5?<FiveApp/>:idx===6?<SixApp/>:<SevenApp/>}
    </div>
  );
}

export default App;
