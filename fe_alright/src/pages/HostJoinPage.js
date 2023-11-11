import JoinForm from "../components/JoinForm";
import NavBar from "../components/NavBar";

const HostJoinPage = () => {
    return (
        <div>
        <NavBar />
        <div style = {{padding: '100px'}}>
            <div className="container d-flex align-items-center justify-content-center vh-50">
                <div className="d-flex flex-column align-items-center">
                    <h1>호스트 사용자 회원가입</h1>
                    <JoinForm />
                </div>
            </div>
        </div>
        </div>
    )
}

export default HostJoinPage;