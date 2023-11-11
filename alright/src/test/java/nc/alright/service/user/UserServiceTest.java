package nc.alright.service.user;

import nc.alright.domain.user.JoinStatus;
import nc.alright.domain.user.LoginStatus;
import nc.alright.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;


    @BeforeEach
    void prepareTestData() {
        // 테스트 데이터를 미리 데이터베이스에 추가
        User user1 = new User();
        user1.setUserEmail("user1@example.com");
        user1.setUserPhoneNumber("1111111111");
        user1.setPassword("password1");
        user1.setUserName("User 1");
        userService.createUser(user1);

        User user2 = new User();
        user2.setUserEmail("user2@example.com");
        user2.setUserPhoneNumber("2222222222");
        user2.setPassword("password2");
        user2.setUserName("User 2");
        userService.createUser(user2);
    }



    @Test
    void joinUserDuplicate() {
        User existingUser = new User();
        existingUser.setUserEmail("user1@example.com");
        existingUser.setUserPhoneNumber("1111111111");
        existingUser.setPassword("password1");
        existingUser.setUserName("User 1");

        JoinStatus status = userService.join(existingUser);

        assertEquals(JoinStatus.DUPLICATE, status);
    }




    @Test
    void loginUser() {
        String userEmail = "user1@example.com";
        String userPassword = "password1";

        LoginStatus status = userService.login(userEmail, userPassword);

        assertEquals(LoginStatus.SUCCESS, status);
    }



    @Test
    void createUser() {
        User newUser = new User();
        newUser.setUserEmail("newuser@example.com");
        newUser.setUserPhoneNumber("3333333333");
        newUser.setPassword("newpassword");
        newUser.setUserName("New User");

        User createdUser = userService.createUser(newUser);

        assertNotNull(createdUser.getUserId());
        assertEquals("newuser@example.com", createdUser.getUserEmail());
        assertEquals("3333333333", createdUser.getUserPhoneNumber());
        assertEquals("newpassword", createdUser.getPassword());
        assertEquals("New User", createdUser.getUserName());

    }

    @Test
    void getUserById() {
        User user = userService.getUserByEmail("user1@example.com");
        User retrievedUser = userService.getUserById(user.getUserId());

        assertEquals(user.getUserId(), retrievedUser.getUserId());
        assertEquals("user1@example.com", retrievedUser.getUserEmail());
    }

    @Test
    void getAllUsers() {
        List<User> userList = userService.getAllUsers();

        assertEquals(2, userList.size());
    }

    @Test
    void updateUser() {
        User user = userService.getUserByEmail("user1@example.com");
        user.setUserEmail("updateduser@example.com");

        User updatedUser = userService.updateUser(user.getUserId(), user);

        assertEquals("updateduser@example.com", updatedUser.getUserEmail());
    }

    @Test
    void deleteUser() {
        User user = userService.getUserByEmail("user1@example.com");
        userService.deleteUser(user.getUserId());

        assertNull(userService.getUserById(user.getUserId()));
    }

    @Test
    void getUserByEmail() {
        User user = userService.getUserByEmail("user1@example.com");

        assertNotNull(user);
        assertEquals("user1@example.com", user.getUserEmail());
    }

    @Test
    void getUserByPhoneNumber() {
        User user = userService.getUserByPhoneNumber("2222222222");

        assertNotNull(user);
        assertEquals("2222222222", user.getUserPhoneNumber());
    }

    @Test
    void getUsersByUserName() {
        List<User> userList = userService.getUsersByUserName("User 1");

        assertEquals(1, userList.size());
        assertEquals("User 1", userList.get(0).getUserName());
    }

}
