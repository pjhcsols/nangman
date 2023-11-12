import {Link,NavLink} from 'react-router-dom';

const NavBar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark" 
        style={{
            background: '#ffffff',
            boxShadow: 'rgba(0, 0, 0, 0.15) 0px 1px 4px',
            zIndex: '100',
            height: '100px'
            }}>
            <div className="container">
                <Link className="navbar-brand mt-1" to="/">
                    <button type="button" style={{ background: 'transparent', border: 'none'}}>
                        <img src={'/img/logo.png'} alt="" height="65" width="65"/>   
                    </button>
                </Link>
                <span style={{ fontWeight: 'bold' }}>우리 아이를 위한 공간 찾기, 얼라잇</span>

                <ul
                style = {{
                    flexDirection: 'row'
                }} 
                className="navbar-nav">
                    <li className="nav-item me-2">
                        <NavLink 
                        activeClassName = "active"
                        className="nav-link" 
                        aria-current="page" 
                        to="/jmode">
                        <span style={{ color: "black" }}>회원가입</span>
                        </NavLink>
                    </li>

                    <li className="nav-item me-2">
                        <NavLink 
                        activeClassName = "active"
                        className="nav-link" 
                        aria-current="page" 
                        to="/lmode">
                        <span style={{ color: "black" }}>로그인</span>
                        </NavLink>
                    </li>
                    <li className="search-container mt-1">
                        <input type="text" className="search-input" placeholder="검색어를 입력하세요" />
                    </li>
                </ul>
            </div>
        </nav>
    );
};

export default NavBar;