import {Map,MapMarker} from 'react-kakao-maps-sdk';
import useWindowSize from '../hooks/useWindowSize';
import useUserPosition from '../hooks/useUserPosition';
import { useState } from 'react';
import defaultData from '../constants/defaultMarkers';
import { useEffect } from 'react';
import { MapInfoWindow } from 'react-kakao-maps-sdk';
import { useMap } from 'react-kakao-maps-sdk';
import kidszone_data from '../location_data/kidszone_data';
import nokidszone_data from '../location_data/nokidszone_data';
import playground_data from '../location_data/playground_data';
import ExitBt from './ExitBt';

const InitMap = () => {
    const windowSize = useWindowSize();
    const userPosition = useUserPosition();
    const positions = defaultData.map(item => ({
        title: item.title,
        latlng: item.latlng
    }));
    const kidszone = kidszone_data.map(item => ({
        title: item.title,
        latlng: item.latlng
    }));
    const nokidszone = nokidszone_data.map(item => ({
        title: item.title,
        latlng: item.latlng
    }));
    const playground = playground_data.map(item => ({
        title: item.title,
        latlng: item.latlng
    }));
    



    const [state, setState] = useState({
        center: {
          lat: 35.88583703617976,
          lng: 128.61011062611178,    //기본 위치
        },
        content: "현 위치",
        errMsg: null,
        isLoading: true,
    })
    
    useEffect(() => {
    if (navigator.geolocation) {
        // GeoLocation을 이용해서 접속 위치를 얻어옵니다
        navigator.geolocation.getCurrentPosition(
        (position) => {
            setState((prev) => ({
            ...prev,
            center: {
                lat: position.coords.latitude, // 위도
                lng: position.coords.longitude, // 경도
            },
            isLoading: false,
            }))
        },
        (err) => {
            setState((prev) => ({
            ...prev,
            errMsg: err.message,
            isLoading: false,
            }))
        }
        )
    } else {
        // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
        setState((prev) => ({
        ...prev,
        errMsg: "geolocation을 사용할수 없어요..",
        isLoading: false,
        }))
    }
    }, [])

    const EventMarkerContainer = ({ position, content ,img}) => {
        const map = useMap()
        const [isVisible, setIsVisible] = useState(false)
        return (
          <MapMarker
            position={position} // 마커를 표시할 위치
            
            onClick={(marker) => setIsVisible(true)}
            
            image={{
                src: img, // 마커이미지의 주소입니다
                size: {
                width: 30,
                height: 40
                }, // 마커이미지의 크기입니다
            }}
          >
            {isVisible && (<ExitBt setIsVisible={setIsVisible} content={content} />)}
          </MapMarker>
        )
    }


    return (
        <div>
        
        <Map
            center={state.center}
            style={{
            width: `${windowSize.width}px`,
            height: `${windowSize.height}px`
            }}
            level={7}
        
        >
            


            
            <EventMarkerContainer position={state.center} content={'현위치'} img={'/img/geo.png'} />
            
            
            {kidszone.map((kidszone, index) => (
                <EventMarkerContainer
                    key={`${kidszone.title}-${kidszone.latlng}`}
                    position={kidszone.latlng} // 마커를 표시할 위치                    
                    title={kidszone.title} // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    content={<div>{kidszone.title}</div>}
                    img={'/img/kids.png'}
                />
                    
                
            ))}

            {nokidszone.map((nokidszone, index) => (
                <EventMarkerContainer
                    key={`${nokidszone.title}-${nokidszone.latlng}`}
                    position={nokidszone.latlng} // 마커를 표시할 위치                    
                    title={nokidszone.title} // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    content={<div>{nokidszone.title}</div>}
                    img={'/img/nokids.png'}
                    />

            ))}

            {playground.map((playground, index) => (
                <EventMarkerContainer
                    key={`${playground.title}-${playground.latlng}`}
                    position={playground.latlng} // 마커를 표시할 위치                    
                    title={playground.title} // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    content={<div>{playground.title}</div>}
                    img={'/img/com.png'}
                    />
            ))}


            
            
        </Map>
        </div>
    )
}

export default InitMap;