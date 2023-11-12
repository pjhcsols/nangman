package nc.alright.controller.user;


import lombok.extern.slf4j.Slf4j;
import nc.alright.domain.user.JoinStatus;
import nc.alright.domain.user.LoginRequest;
import nc.alright.domain.user.LoginStatus;
import nc.alright.domain.user.User;
import nc.alright.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
/*
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        JoinStatus result = userService.join(user);
        return new ResponseEntity<>(result.getMessage(), result.getStatus());
    }



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        log.info("-------------------" + loginRequest.getUserPassword() + "-------------------");
        LoginStatus loginResult = userService.login(loginRequest.getUserEmail(), loginRequest.getUserPassword());
        if (loginResult != LoginStatus.SUCCESS)return new ResponseEntity<>(loginResult.getMessage(), loginResult.getStatus());
        log.info("------------------------------------------------------------");
        String token = userService.afterSuccessLogin(loginRequest.getUserEmail());
        log.info(token);
        return ResponseEntity.ok().body(token);
    }

        /*
        if (loginResult != LoginStatus.SUCCESS) {
            return new ResponseEntity<>(loginResult.getMessage(), loginResult.getStatus());
        }

        // 로그인 성공시 토큰 생성 로직이 없으므로, 로그인 성공 메시지 반환
        return ResponseEntity.ok().body("Login successful.");
    }

*/

//Neo4jProperties 수정하기
    @PostMapping("/review")
    public ResponseEntity<String> writeReview(Authentication authentication) {
        return ResponseEntity.ok().body(authentication.getName() + "님의 리뷰 등록이 완료되었습니다.");
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserInfoById(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/email/{userEmail}")
    public User getUserByEmail(@PathVariable String userEmail) {
        return userService.getUserByEmail(userEmail);
    }

    @GetMapping("/phone/{userPhoneNumber}")
    public User getUserByPhoneNumber(@PathVariable String userPhoneNumber) {
        return userService.getUserByPhoneNumber(userPhoneNumber);
    }

    @GetMapping("/name/{userName}")
    public List<User> getUsersByUserName(@PathVariable String userName) {
        return userService.getUsersByUserName(userName);
    }
}
