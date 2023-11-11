import {Link,NavLink} from 'react-router-dom';

const NavBar = () => {
    return (
        <nav className="navbar navbar-dark bg-dark">
            <div className="container">
                <Link className="navbar-brand mt-1" to="/">
                    <button type="button" style={{ background: 'transparent', border: 'none'}}>
                        <img src={'/img/logo.png'} alt="" height="50" width="50"/>   
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
                        to="/login">
                        로그인</NavLink>
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