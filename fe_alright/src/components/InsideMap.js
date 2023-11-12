import {useMap} from "react-kakao-maps-sdk";
import useMarkers from "../hooks/useMarkers";

export default function InsideMap() {
    const map = useMap();
    const mapMarkers = useMarkers(map); // useMarkers 커스텀 훅을 호출하여 반환된 markers 배열을 받아옴

    return (
        mapMarkers
    );
}