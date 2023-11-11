package nc.alright.repository.user;

import nc.alright.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    // 사용자를 생성하는 메서드
    User createUser(User user);

    // 사용자 고유 ID로 사용자를 조회하는 메서드
    User getUserById(Long userId);

    // 모든 사용자 목록을 조회하는 메서드
    List<User> getAllUsers();

    // 사용자 고유 ID로 사용자를 업데이트하는 메서드
    User updateUser(Long userId, User updatedUser);

    // 사용자 고유 ID로 사용자를 삭제하는 메서드
    void deleteUser(Long userId);

    // 이메일 주소를 사용하여 사용자를 조회하는 메서드
    User getUserByEmail(String userEmail);

    // 전화번호를 사용하여 사용자를 조회하는 메서드
    User getUserByPhoneNumber(String userPhoneNumber);

    // 사용자 이름을 사용하여 사용자를 조회하는 메서드
    List<User> getUsersByUserName(String userName);

    Optional<User> findByEmail(String userEmail);

    User save(User User);

}

