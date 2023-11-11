import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from 'react-router-dom';
import routes from '../routes';
import HostNavBar from '../components/HostNavBar';
import InitMap from '../components/InitMap';

const HostPage = () => {
//   const windowSize = useWindowSize();
//   const userPosition = useUserPosition();
//   const [count, setCount] = useState(0);

//   useEffect(() => {
//     console.log(userPosition);
//   }, []);

  return (
    <div>
    <HostNavBar />
    <InitMap />
    </div>
  )
}

export default HostPage;
