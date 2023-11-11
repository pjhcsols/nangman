import {Link,NavLink} from 'react-router-dom';

const HostNavBar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark" style={{ background: 'linear-gradient(to bottom, #FFB21D, #ffffff)' }}>
            <div className="container">
                <Link className="navbar-brand mt-1" to="/">
                    <button type="button" style={{ background: 'transparent', border: 'none'}}>
                        <img src={'/img/logo.png'} alt="" height="65" width="65"/>   
                    </button>
                </Link>
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
                        to="/host/main/post">
                        키즈존 등록</NavLink>
                    </li>

                    {/* <li className="nav-item me-2">
                        <NavLink 
                        activeClassName = "active"
                        className="nav-link" 
                        aria-current="page" 
                        to="/mode">
                        로그인</NavLink>
                    </li> */}
                    {/* <li className="search-container mt-1">
                        <input type="text" className="search-input" placeholder="검색어를 입력하세요" />
                    </li> */}
                </ul>
            </div>
        </nav>
    );
};

export default HostNavBar;