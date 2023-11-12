package nc.alright.repository.user;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import nc.alright.domain.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Repository
@Slf4j
public class JpaUserRepository implements UserRepository {

    //@PersistenceContext
    private final EntityManager entityManager;

    public JpaUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User createUser(User user) {
        // 고유 ID 생성 및 설정
        user.setUserId(null); // ID는 자동 생성
        entityManager.persist(user);
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = entityManager.find(User.class, userId);
        if (existingUser != null) {
            // 업데이트된 정보로 사용자 업데이트
            existingUser.setUserEmail(updatedUser.getUserEmail());
            existingUser.setUserPhoneNumber(updatedUser.getUserPhoneNumber());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setUserName(updatedUser.getUserName());
            entityManager.merge(existingUser);
            return existingUser;
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }
/*
    @Override
    public User getUserByEmail(String userEmail) {
        String jpql = "SELECT u FROM User u WHERE u.userEmail = :userEmail";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("userEmail", userEmail);
        return query.getSingleResult();
    }

 */
    @Override
    public User getUserByEmail(String userEmail) {
        String jpql = "SELECT u FROM User u WHERE u.userEmail = :userEmail";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("userEmail", userEmail);

        List<User> users = query.getResultList();

        if (users.isEmpty()) {
            return null; // 사용자를 찾지 못한 경우
        } else if (users.size() == 1) {
            return users.get(0); // 고유한 결과인 경우
        } else {
            throw new NonUniqueResultException("----------Query returned non-unique result---------");
        }
    }


    @Override
    public User getUserByPhoneNumber(String userPhoneNumber) {
        String jpql = "SELECT u FROM User u WHERE u.userPhoneNumber = :userPhoneNumber";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("userPhoneNumber", userPhoneNumber);
        return query.getSingleResult();
    }

    @Override
    public List<User> getUsersByUserName(String userName) {
        String jpql = "SELECT u FROM User u WHERE u.userName = :userName";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("userName", userName);
        return query.getResultList();
    }

    @Override
    public Optional<User> findByEmail(String userEmail) {
        try {
            User user = entityManager.createQuery("select m from User m where m.userEmail = :emailAddress", User.class).setParameter("emailAddress", userEmail).getSingleResult();
            return Optional.ofNullable(user);
        }catch(NoResultException e){
            return Optional.empty();
        }

    }

    @Override
    public User save(User User) {
        entityManager.persist(User);
        return User;
    }

}
