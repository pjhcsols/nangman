import React from "react";

const LoginForm = ({ id, history }) => {
  const handleFormSubmit = () => {
    if (id === 1) {
      history.push("/host/main");
    } else {
      console.log(id);
      console.log(history);
    }
  };

  return (
    <div>
      <div>
        <div className="mb-3">
          <label className="from-label">이메일을 입력하세요</label>
          <div>
            <input className="login-email" type="text" />
          </div>
        </div>
        <div className="mb-3">
          <label className="from-label">비밀번호를 입력하세요</label>
          <div>
            <input className="login-pwd" type="password" />
          </div>
        </div>
      </div>

      <button className="btn btn-primary ms-2" onClick={handleFormSubmit}>
        입력 완료
      </button>
    </div>
  );
};

export default LoginForm;
