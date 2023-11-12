import { Link, Route, Switch, useHistory } from "react-router-dom";
import NavBar from "./NavBar";
import LoginForm from "./LoginForm";

const LoginMode = () => {
  const history = useHistory();

  const handleUserLogin = () => {
    const id = 0;
  };

  const handleHostLogin = () => {
    const id = 1;
    history.push("/host/main")
  };

  return (
    <div>
      <NavBar />
      <div style={{ padding: "100px" }}>
        <div className="container d-flex align-items-center justify-content-center vh-50">
          <div className="d-flex flex-column align-items-center">
            <h1>로그인 모드를 선택해주세요</h1>
            <Link className="navbar-brand mt-1" to="/user/login">
              <button className="btn btn-primary ms-2" onClick={handleUserLogin}>
                일반 사용자
              </button>
            </Link>
            <Link className="navbar-brand mt-1" to="/host/login">
              <button className="btn btn-primary ms-2" onClick={handleHostLogin}>
                호스트 사용자
              </button>
            </Link>
            {/* <Switch>
              <Route
                path="/user/login"
                render={() => <LoginForm id={0} history={history} />}
              />
              <Route
                path="/host/login"
                render={() => <LoginForm id={1} history={history} />}
              />
            </Switch> */}
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginMode;
