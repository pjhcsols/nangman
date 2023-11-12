import { Link
} from "react-router-dom/cjs/react-router-dom.min";
import NavBar from "./NavBar";

const JoinMode = () => {
   return (
       <div>
       <NavBar />
       <div style = {{padding: '100px'}}>
           <div className="container d-flex align-items-center justify-content-center vh-50">
               <div /*className="d-flex flex-column align-items-center"*/>
                   <h1>회원가입 모드를 선택해주세요</h1>
                   <ul style = {{
                    flexDirection: 'row'
                    }} className="join-mode">
                   <Link className="navbar-brand mt-1" to="/jmode/user">
                       <button
                       className="btn btn-primary ms-2"
                       style={{ width: '200px', height: '100px' }}
                       // onClick ={onSubmit}
                       >
                       일반 사용자로 회원가입
                       </button>
                   </Link>
                   <Link className="navbar-brand mt-1" to="/jmode/host">
                       <button
                       className="btn btn-danger ms-2"
                       style={{ width: '200px', height: '100px' }}
                       // onClick ={onSubmit}
                       >
                       호스트 사용자로 회원가입
                       </button>
                   </Link>
                   </ul>
               </div>
           </div>
       </div>
       </div>
   )
}

export default JoinMode;