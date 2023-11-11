const JoinForm = () => {
    return (
        <div>
            <div>
                <div className="mb-3">
                    <label className="from-label">이름을 입력하세요</label>
                        <div>
                        <input
                            className="join-name"
                            type="text"
                            // value={pwd}
                            // onChange={(e) => {
                            //     setPwd(e.target.value);
                            // }}
                        />
                        </div>
                </div>

                <div className="mb-3">
                    <label className="from-label">전화번호를 입력하세요</label>
                        <div>
                        <input
                            className="join-number"
                            type="text"
                            // value={pwd}
                            // onChange={(e) => {
                            //     setPwd(e.target.value);
                            // }}
                        />
                        </div>
                </div>

                <div className="mb-3">
                    <label className="from-label">이메일을 입력하세요</label>
                        <div>
                        <input
                            className="join-email"
                            type="text"
                            // value={pwd}
                            // onChange={(e) => {
                            //     setPwd(e.target.value);
                            // }}
                        />
                        </div>
                </div>
                <div className="mb-3">
                    <label className="from-label">비밀번호를 입력하세요</label>
                        <div>
                        <input
                            className="join-pwd"
                            type="password"
                            // value={pwd}
                            // onChange={(e) => {
                            //     setPwd(e.target.value);
                            // }}
                        />
                        </div>
                </div>
            </div>
            
            <button
                className="btn btn-primary ms-2"
                // onClick ={onSubmit}
                >
                입력 완료
            </button>
        </div>
    )
    
}

export default JoinForm;