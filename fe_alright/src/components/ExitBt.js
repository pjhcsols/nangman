import propTypes from 'prop-types';

const ExitBt = ({setIsVisible,content}) => {
    return (
        <div style={{ minWidth: "150px" }}>
            <img
              alt="close"
              width="14"
              height="13"
              src="https://t1.daumcdn.net/localimg/localimages/07/mapjsapi/2x/bt_close.gif"
              style={{
                position: "absolute",
                right: "5px",
                top: "5px",
                cursor: "pointer",
              }}
              onClick={() => setIsVisible(false)}
            />
            <div style={{ padding: "5px", color: "#000" }}>{content}</div>
        </div>
    )

}
export default ExitBt;