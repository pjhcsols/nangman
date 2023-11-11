import HostLoginPage from "./pages/HostLoginPage";
import HostPage from "./pages/HostPage";
import LoginMode from "./components/LoginMode";
import UserLoginPage from "./pages/UserLoginPage";
import HostPostPage from "./pages/HostPostPage";
import JoinMode from "./components/JoinMode";
import UserJoinPage from "./pages/UserJoinPage";
import HostJoinPage from "./pages/HostJoinPage";

const routes = [
    {
        path : '/lmode',
        component : LoginMode
    },
    {
        path : '/jmode',
        component : JoinMode
    },
    {
        path : '/jmode/user',
        component : UserJoinPage
    },
    {
        path : '/jmode/host',
        component : HostJoinPage
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
        component : HostPostPage
    }
]

export default routes;