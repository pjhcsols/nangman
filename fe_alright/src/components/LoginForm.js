import React, {useEffect, useState} from "react";
import {useHistory} from "react-router-dom";
import axios from 'axios';


const LoginForm = () => {
    const [email, setEmail] = useState("");
    const [pwd, setPwd] = useState("");
    const history = useHistory();

    const onSubmit = () => {
        const data = {
            email: email,
            password: pwd
        };
        
        console.log(data);
        axios.post('http://172.20.5.147:8080/users/signup', JSON.stringify(data), {
          headers: {
            'Content-Type': 'application/json'
          }
        })
        .then(res=> {
            const data = res.data
            console.log(data.code)
            console.log(data.message)
            console.log(data.status)
            history.push('/host/main');
          })
        .catch(error => {
            console.error(error);
          });
    };
    
    const handleEmailChange = (e) => {
        setEmail(e.target.value);
        console.log(email);
    }

    const handlePwdChange = (e) => {
        setPwd(e.target.value);
        console.log(pwd);
    }

    // const handleFormSubmit = () => {
    //     if (email === "admin" && pwd === "1234") {
    //         localStorage.setItem("id", email);
    //         localStorage.setItem("isLoggedIn", true);
    //         history.push("/host/main");
    //     } else {
    //         console.log(email, pwd);
    //         alert("아이디 또는 비밀번호가 틀렸습니다.");
    //     }
    // }

    return (
        <div>
            <div>
                <div className="mb-3">
                    <label className="from-label">이메일을 입력하세요</label>
                    <div>
                        <input value={email} onChange={handleEmailChange} className="login-email" type="text"/>
                    </div>
                </div>
                <div className="mb-3">
                    <label className="from-label">비밀번호를 입력하세요</label>
                    <div>
                        <input value={pwd} onChange={handlePwdChange} className="login-pwd" type="password"/>
                    </div>
                </div>
            </div>

            <button className="btn btn-primary ms-2" onClick={onSubmit}>
                입력 완료
            </button>
        </div>
    );
};

export default LoginForm;
