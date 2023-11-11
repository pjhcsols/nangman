import axios from "axios";
import React, {useEffect, useState} from "react";
import {useHistory} from "react-router-dom";

const JoinForm = () => {
    const [email, setEmail] = useState("");
    const [pwd, setPwd] = useState("");
    const [name, setName] = useState("");
    const [number, setNumber] = useState("");

    const history = useHistory();

    const onSubmit = () => {
        const data = {
            userEmail: email,
            password: pwd,
            userName : name,
            userPhoneNumber : number
        };
        
        console.log(data);
        axios.post('http://172.20.38.52:8080/users/signup', JSON.stringify(data), {
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
    const handleNameChange = (e) => {
        setName(e.target.value);
        console.log(name);
    }
    const handleNumberChange = (e) => {
        setNumber(e.target.value);
        console.log(number);
    }

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
                <div className="mb-3">
                    <label className="from-label">이름을 입력하세요</label>
                    <div>
                        <input value={name} onChange={handleNameChange} className="login-name" type="text"/>
                    </div>
                </div>
                <div className="mb-3">
                    <label className="from-label">전화번호를 입력하세요</label>
                    <div>
                        <input value={number} onChange={handleNumberChange} className="login-num" type="text"/>
                    </div>
                </div>
            </div>

            <button className="btn btn-primary ms-2" onClick={onSubmit}>
                입력 완료
            </button>
    </div>
    )
    
}

export default JoinForm;