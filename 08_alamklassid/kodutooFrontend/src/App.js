//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); //HTMLs esinevad muutujad peavad olema useState sees
  const [planeedid, setPlaneedid] = useState([]);
  const nimiRef = useRef();
  const labimootRef = useRef();
  const kaugusRef = useRef();
  const [planeedikomponendid, setPlaneedikomponendid] = useState([]);

//Reactid hookid: 'use' eesliidesega, neid peab importima. Reacti erikood
//Springis annotatsioonid: @RestController, @GetMapping, neid peab importima. Springi erikood


//uef -> JS: onLoad()
  useEffect(() => {
    fetch("http://localhost:3000/planeedikomponendid")
    .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK jne)
    .then(json => {
      setPlaneedikomponendid(json);
    }) //body
  }, []);

  useEffect(()=> {
    fetch("http://localhost:3000/api/planeedid/")
    .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK jne)
    .then(json => {
      setKogus(json.length);
      setPlaneedid(json);
    }) //body
  }, []);

  function kustuta(primaarvoti) {
    fetch("http://localhost:3000/api/planeedid/" + primaarvoti, {"method": "DELETE"})
    .then(response => response.json())
    .then(json => {
      setKogus(json.length);
      setPlaneedid(json);
    })
  }

  function kustutaPK(primaarvoti) {
    fetch("http://localhost:3000/planeedikomponendid/" + primaarvoti, {"method": "DELETE"})
    .then(response => response.json())
    .then(json => {
      setPlaneedikomponendid(json);
    })
  }

  function lisa() {
    if (nimiRef.current.value === ""){
      return;
    }
    const number = {
      "nimetus": nimiRef.current.value,
      "labimoot": labimootRef.current.value,
      "kaugus": kaugusRef.current.value
    }
    fetch("http://localhost:3000/api/planeedid", 
    {
      "method": "POST", 
      "body": JSON.stringify(number), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        console.log(json);
        setKogus(json.length);
        setPlaneedid(json);
      })
  }

  const planeetRef = useRef();
  const galatikaRef = useRef();
  
  function lisaPK() {
    const lisatavPK = {
      "planeet": {"nimetus": planeetRef.current.value},
      "galatika": galatikaRef.current.value
    }
    fetch("http://localhost:3000/planeedikomponedid",
    {
      "method": "POST",
      "body": JSON.stringify(lisatavPK),
      "headers": {"Content-Type": "application/json"}
    })
    .then(response => response.json())
    .then(json => {
      setPlaneedikomponendid(json);
    })
  }

  return (
    <div className="App">
      Mul on {kogus} planeet(i) lisatud nimekirja
      <br/><br/>
      <label>Planeedi nimetus</label><br/>
      <input ref={nimiRef} type ="text"/><br/>
      <label>Planeedi läbimõõt</label><br/>
      <input ref={labimootRef} type ="number"/><br/>
      <label>Planeedi kaugus maast</label><br/>
      <input ref={kaugusRef} type ="number"/><br/>
      <button onClick={() => lisa()}>Sisesta</button><br/>
      <br/>
      <div className="table-container">
      <table>
        <thead>
          <tr>
            <th>Nimetus</th>
            <th>Läbimõõt</th>
            <th>Kaugus</th>
            <th>Kustuta</th>
          </tr>
        </thead>
        <tbody>
          {planeedid.map((t, index) => (
            <tr key={index}>
              <td>{t.nimetus}</td>
              <td>{t.labimoot}</td>
              <td>{t.kaugus}</td>
              <td><button onClick={() => kustuta(t.nimetus)}>x</button></td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
      <hr />
      <label>Planeedi nimi (Täpne nimi andmebaasist)</label><br/>
      <input ref={planeetRef} type ="text"/><br/>
      <label>Galatika kus ta asub</label><br/>
      <input ref={galatikaRef} type ="text"/><br/><br/>
      <button onClick={() => lisaPK()}>Sisesta</button><br/>

      {planeedikomponendid.map(tk => <div>{tk.id} | {tk.planeet?.nimetus} | <button onClick={() => kustutaPK(tk.id)}>x</button> </div>)}

    </div>
  );
}

export default App;
