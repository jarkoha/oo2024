//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [autod, setAutod] = useState([]);
  const markRef = useRef();
  const pikkusRef = useRef();
  const massRef = useRef();
  const aastaRef = useRef();
 

  useEffect(() => {
    fetch("http://localhost:8080/autod")
    .then(response => response.json()) 
    .then(json => {
      setAutod(json);
    })
  }, []);

  function kustuta(primaarvoti) {
    fetch("http://localhost:8080/autod/" + primaarvoti, {"method": "DELETE"})
    .then(response => response.json())
    .then(json => {
      setAutod(json);
    })
  }


  function lisa() {
    if (markRef.current.value.trim() === ""){
      return;
    }
    const auto = {
      "mark": markRef.current.value,
      "pikkus": pikkusRef.current.value,
      "mass": massRef.current.value,
      "aasta": aastaRef.current.value
    }
    fetch("http://localhost:8080/autod", 
    {
      "method": "POST", 
      "body": JSON.stringify(auto), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setAutod(json);
      })
  }


  return (
    <div className="App">
      <br/><br/>
      <label>Auto mark</label><br/>
      <input ref={markRef} type ="text"/><br/>
      <label>Auto pikkus</label><br/>
      <input ref={pikkusRef} type ="number"/><br/>
      <label>Auto mass</label><br/>
      <input ref={massRef} type ="number"/><br/>
      <label>Auto väljalaske aasta</label><br/>
      <input ref={aastaRef} type ="number"/><br/><br/>
      <button onClick={() => lisa()}>Sisesta</button><br/>
      <br/>

      {autod.map(t => <div>{t.mark} | {t.pikkus} | {t.mass} | {t.aasta} | <button onClick={() => kustuta(t.mark)}>x</button> </div>)}
      <hr />
    
    </div>
  );
}

export default App;
