import { Link
 } from "react-router-dom/cjs/react-router-dom.min";
const LoginMode = () => {
    return (
        <div style = {{padding: '100px'}}>
            <div className="container d-flex align-items-center justify-content-center vh-50">
                <div className="d-flex flex-column align-items-center">
                    <h1>로그인 모드를 선택해주세요</h1>
                    <Link className="navbar-brand mt-1" to="/user/login">
                        <button
                        className="btn btn-primary ms-2"
                        // onClick ={onSubmit}
                        >
                        일반 사용자
                        </button>
                    </Link>
                    <Link className="navbar-brand mt-1" to="/host/login">
                        <button
                        className="btn btn-primary ms-2"
                        // onClick ={onSubmit}
                        >
                        호스트 사용자
                        </button>
                    </Link>
                </div>
            </div>
        </div>
    )
}

export default LoginMode;