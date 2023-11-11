import HostLoginPage from "./pages/HostLoginPage";
import HostPage from "./pages/HostPage";
import HostPost from "./pages/HostPost";
import JoinPage from "./pages/JoinPage";
import LoginMode from "./pages/LoginMode";
import UserLoginPage from "./pages/UserLoginPage";

const routes = [
    {
        path : '/mode',
        component : LoginMode
    },
    {
        path : '/join',
        component : JoinPage
    },
    {
        path : '/user/login',
        component : UserLoginPage
    },
    {
        path : '/host/login',
        component : HostLoginPage
    },
    {
        path : '/host/main',
        component : HostPage
    },
    {
        path : '/host/main/post',
        component : HostPost
    }
]

export default routes;