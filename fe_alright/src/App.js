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

function App() {
  const windowSize = useWindowSize();
  const userPosition = useUserPosition();
  // const markers = useMarkers();
  const [count,setCount] = useState(0);

  useEffect(() => {
      console.log(userPosition);
  }, []);

  return (
    <Router>
      <Switch>
          {routes.map((route) => {
            return <Route key={route.path} exact path={route.path} component={route.component} />
          })}
          <Route path="/">
            <NavBar />
            <Map
              center={{ lat: 35.88583703617976, lng: 128.61011062611178 }}
              style={{
                width: `${windowSize.width}px`,
                height: `${windowSize.height}px`
              }}
              level={3}
            >
              <InsideMap />
            </Map>
          </Route>
      </Switch>
    </Router>
  )
}

export default App;
