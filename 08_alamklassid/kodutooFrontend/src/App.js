//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); //HTMLs esinevad muutujad peavad olema useState sees
  const [numbrid, setNumbrid] = useState([]);
  const nimiRef = useRef();
  const numberRef = useRef();
  const [paaris, setPaaris] = useState(null);

//Reactid hookid: 'use' eesliidesega, neid peab importima. Reacti erikood
//Springis annotatsioonid: @RestController, @GetMapping, neid peab importima. Springi erikood


//uef -> JS: onLoad()
  useEffect(() => {
    fetch("http://localhost:8080/api/numbrid")
    .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK jne)
    .then(json => {
      console.log(json);
      setKogus(json.length);
      setNumbrid(json);
    }) //body
  }, []);

  function kustuta(primaarvoti) {
    fetch("http://localhost:8080/api/numbrid/" + primaarvoti, {"method": "DELETE"})
    .then(response => response.json())
    .then(json => {
      setKogus(json.length);
      setNumbrid(json);
    })
  }

  function lisa() {
    if (nimiRef.current.value === ""){
      return;
    }
    const number = {
      "nimetus": nimiRef.current.value,
      "number": parseInt(numberRef.current.value, 10),
      "paaris": paaris
    }
    fetch("http://localhost:8080/api/numbrid", 
    {
      "method": "POST", 
      "body": JSON.stringify(number), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        console.log(json);
        setKogus(json.length);
        setNumbrid(json);
      })
  }

  return (
    <div className="App">
      Mul on {kogus} numbrit lisatud nimekirja
      <br/><br/>
      <label>Numbri nimetus</label><br/>
      <input ref={nimiRef} type ="text"/><br/>
      <label>Number arvu(de)na</label><br/>
      <input ref={numberRef} type ="number"/><br/>
      <label>Kas on paaris või ei?</label><br/>
      <input
        type="radio"
        id="paarisTrue"
        name="paaris"
        value="true"
        onChange={() => setPaaris(true)}
      /><label htmlFor="paarisTrue">Jah</label>
      <input
        type="radio"
        id="paarisFalse"
        name="paaris"
        value="false"
        onChange={() => setPaaris(false)}
      /><label htmlFor="paarisFalse">Ei</label><br/><br/>
      <button onClick={() => lisa()}>Sisesta</button><br/>
      <br/>

      {numbrid.map(t => (
        <div key={t.nimetus}>{t.nimetus}<button onClick={() => kustuta(t.nimetus)}>x</button></div>
      ))}
    </div>
  );
}

export default App;
