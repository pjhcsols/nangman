import {Map,MapMarker} from 'react-kakao-maps-sdk';
import useWindowSize from '../hooks/useWindowSize';
import useUserPosition from '../hooks/useUserPosition';
import { useState } from 'react';
import defaultData from '../constants/defaultMarkers';

const InitMap = () => {
    const windowSize = useWindowSize();
    const userPosition = useUserPosition();
    const positions = defaultData.map(item => ({
        title: item.title,
        latlng: item.latlng
    }));

    return (
        <div>
        <Map
        center={{ lat: 35.88583703617976, lng: 128.61011062611178 }}
        style={{
        width: `${windowSize.width}px`,
        height: `${windowSize.height}px`
        }}
        level={3}
        // onClick={(_t, mouseEvent) => setPosition({
        //     lat: mouseEvent.latLng.getLat(),
        //     lng: mouseEvent.latLng.getLng(),
        //   })}
        >
            {positions.map((position, index) => (
                <MapMarker
                key={`${position.title}-${position.latlng}`}
                position={position.latlng} // 마커를 표시할 위치
                image={{
                    src: "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png", // 마커이미지의 주소입니다
                    size: {
                    width: 24,
                    height: 35
                    }, // 마커이미지의 크기입니다
                }}
                title={position.title} // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                />
            ))}
            
        </Map>
        {/* {position && <p>{'클릭한 위치의 위도는 ' + position.lat + ' 이고, 경도는 ' + position.lng + ' 입니다'}</p>} */}
        </div>
    )
}

export default InitMap;