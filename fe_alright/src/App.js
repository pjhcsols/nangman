import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
 } from 'react-router-dom';
import {Map} from 'react-kakao-maps-sdk';
import useWindowSize from "./hooks/useWindowSize";
import useUserPosition from "./hooks/useUserPosition";
import {useState,useEffect} from "react";
import InsideMap from "./components/InsideMap";
import NavBar from './components/NavBar';
import routes from './routes';
import InitMap from './components/InitMap';

function App() {
  // const windowSize = useWindowSize();
  // const userPosition = useUserPosition();
  // const markers = useMarkers();

  // useEffect(() => {
  //     console.log(userPosition);
  // }, []);

  return (
    <Router>
      <Switch>
          {routes.map((route) => {
            return <Route key={route.path} exact path={route.path} component={route.component} />
          })}
          <Route exact path="/">
            <NavBar />
            <InitMap />
          </Route>
      </Switch>
    </Router>
  )
}

export default App;

