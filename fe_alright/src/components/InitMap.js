import {Map} from 'react-kakao-maps-sdk';
import useWindowSize from '../hooks/useWindowSize';
import useUserPosition from '../hooks/useUserPosition';
import InsideMap from './InsideMap';

const InitMap = () => {
    const windowSize = useWindowSize();
    const userPosition = useUserPosition();

    return (
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
    )
}

export default InitMap;