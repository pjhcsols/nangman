import {useMap,Map,MapMarker} from 'react-kakao-maps-sdk';
import useWindowSize from '../hooks/useWindowSize';
import useUserPosition from '../hooks/useUserPosition';
import { useEffect,useState } from 'react';
import axios from 'axios';
import ExitBt from './ExitBt';
import complex_data from '../location_data/complex_data';
import kidszone_data from '../location_data/kidszone_data';
import nokidszone_data from '../location_data/nokidszone_data';

const InitMap = () => {
    const windowSize = useWindowSize();
    const userPosition = useUserPosition();
    const kidszone = kidszone_data.map(item => ({
        title: item.title,
        latlng: item.latlng,
        category: item.category,
        address: item.address
    }));
    const nokidszone = nokidszone_data.map(item => ({
        title: item.title,
        latlng: item.latlng,
        category: item.category,
        address: item.address
    }));
    const complex = complex_data.map(item => ({
        title: item.title,
        latlng: item.latlng,
        category: item.category,
        address: item.address
    }));

    let positions = [
        {
          storeId: 0,
          storeName: "",
          storePhoneNumber: "",
          storeAddress: "",
          storeLatitude: 0.0,
          storeLongitude: 0.0,
          storeCategoryId: "",
          storeImage: "",
        },
        // 추가적인 위치 정보 객체들...
      ];
    // const positions = defaultData.map(item => ({
    //     title: item.title,
    //     latlng: item.latlng
    // }));
    const [yes,setYes] = useState(0);
    const [no,setNo] = useState(0);
    const [com,setCom] = useState(0);
    const [all,setAll] = useState(0);

    const onChangeYes = (e) => {
        setYes(e.target.checked)
    }
    const onChangeNo = (e) => {
        setNo(e.target.checked)
    }
    const onChangeCom = (e) => {
        setCom(e.target.checked)
    }
    const onChangeAll = (e) => {
        setAll(e.target.checked)
    }

    useEffect(() => {
        console.log(yes,no,com,all);
        let categoryId;

        if (no === true) {
            categoryId = '1';
            axios.get(`http://server:8080/categories/${categoryId}/stores`)
                .then(response => {
                // 서버 응답 처리
                console.log('서버 응답:', response.data);
                // 원하는 로직을 구현하고 필요한 경우 상태를 업데이트할 수 있습니다.
                })
                .catch(error => {
                // 오류 처리
                console.error('서버 요청 오류:', error);
                });
        }
        if (yes === true) {
            categoryId = '2';
            axios.get(`http://server:8080/categories/${categoryId}/stores`)
                .then(response => {
                console.log('서버 응답:', response.data); // 서버 응답 처리
                })
                .catch(error => {
                console.error('서버 요청 오류:', error); // 오류 처리
                });
        }
        if (com === true) {
            categoryId = '3';
            axios.get(`http://server:8080/categories/${categoryId}/stores`)
                .then(response => {
                // 서버 응답 처리
                console.log('서버 응답:', response.data);
                // 원하는 로직을 구현하고 필요한 경우 상태를 업데이트할 수 있습니다.
                })
                .catch(error => {
                // 오류 처리
                console.error('서버 요청 오류:', error);
                });
        }
        if (all === true) {
            axios.get('http://172.20.10.204:8080/stores/allstore')
                .then(response => {
                positions = response.data.map(item => ({
                    storeId : item.storedId,
                    storeName : item.storeName,
                    storePhoneNumber : item.storePhoneNumber,
                    storeAddress : item.storeAddress,
                    storeLatitude : parseFloat(item.storeLatitude),
                    storeLongitude : parseFloat(item.storeLongitude),
                    storeCategoryId : item.storeCategoryId,
                    storeImage : item.storeImage,
                    lat: parseFloat(item.storeLatitude),
                    lng: parseFloat(item.storeLongitude)
                }))
                console.log('서버 응답:', response.data);
                // 원하는 로직을 구현하고 필요한 경우 상태를 업데이트할 수 있습니다.
                })
                .catch(error => {
                // 오류 처리
                console.error('서버 요청 오류:', error);
                });
        }
    }, [yes,no,com,all]);

    useEffect(() => {
        // positions 배열이 변경될 때마다 실행되는 콜백 함수
        const addMarkersToMap = () => {
            {positions.map((position) => (
                <MapMarker
                key={`${position.storeName}-${position.storeLatitude}-${position.storeLongitude}`}
                position = {{ lat: position.lat, lng: position.lng }}
                image={{
                    src: "/img/kids.png", // 마커이미지의 주소입니다
                    size: {
                    width: 24,
                    height: 35
                    }, // 마커이미지의 크기입니다
                }}
                title={position.storeName} // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                />
            ))}
        };
    
        addMarkersToMap(); // 초기 렌더링 시에도 실행
      }, [positions]);


    
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

        const EventMarkerContainer = ({ position, content,img,category,address}) => {
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
                {isVisible && (<ExitBt setIsVisible={setIsVisible} content={content} category={category} address={address} />)}
              </MapMarker>
            )
        }

    return (
        <div>
            <ul
            className="navbar-nav me-5" style={{ display: 'flex', flexDirection: 'row',justifyContent: 'flex-end'}}> 
                <li className="nav-item me-2">
                    <input className = "form-check-input" type = "checkbox" checked={yes} onChange={onChangeYes}/>
                    <label className="form-check-label">
                        YES 키즈존
                    </label>
                </li>
                <li className="nav-item me-2" >
                    <input className = "form-check-input" type = "checkbox" checked={no} onChange={onChangeNo} />
                    <label className="form-check-label">
                        NO 키즈존
                    </label>
                </li>
                <li className="nav-item me-2" >
                    <input className = "form-check-input" type = "checkbox" checked={com} onChange={onChangeCom}/>
                    <label className="form-check-label">
                        복합문화공간
                    </label>
                </li>
                <li className="nav-item me-2" >
                    <input className = "form-check-input" type = "checkbox" checked={all} onChange={onChangeAll}/>
                    <label className="form-check-label">
                        모두 가져오기
                    </label>
                </li>
                
            </ul>

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
            <EventMarkerContainer position={state.center} content={'현위치'} img={'/img/geo.png'} />

            {kidszone.map((kidszone) => (
                <EventMarkerContainer
                    key={`${kidszone.title}-${kidszone.latlng}`}
                    position={kidszone.latlng} // 마커를 표시할 위치                    
                    content={kidszone.title }
                    address={kidszone.address}
                    category={kidszone.category}
                    img={'/img/kids.png'}
                />
                    
                
            ))}

            {nokidszone.map((nokidszone) => (
                <EventMarkerContainer
                    key={`${nokidszone.title}-${nokidszone.latlng}`}
                    position={nokidszone.latlng} // 마커를 표시할 위치                    
                    content={nokidszone.title}
                    address={nokidszone.address}
                    category={nokidszone.category}
                    img={'/img/nokids.png'}
                    />

            ))}

            {complex.map((complex) => (
                <EventMarkerContainer
                    key={`${complex.title}-${complex.latlng}`}
                    position={complex.latlng} // 마커를 표시할 위치                    
                    content={complex.title}
                    address={complex.address}
                    category={complex.category}
                    img={'/img/com.png'}
                    />
            ))}

            
        </Map>
        {/* {position && <p>{'클릭한 위치의 위도는 ' + position.lat + ' 이고, 경도는 ' + position.lng + ' 입니다'}</p>} */}
        </div>
    )
}

export default InitMap;