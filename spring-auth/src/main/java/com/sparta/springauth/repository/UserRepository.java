package com.sparta.springauth.repository;

import com.sparta.springauth.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);//username이 데이터 베이스에 있을 수도 없을 수도 있다.
    Optional<User> findByEmail(String email);
}
