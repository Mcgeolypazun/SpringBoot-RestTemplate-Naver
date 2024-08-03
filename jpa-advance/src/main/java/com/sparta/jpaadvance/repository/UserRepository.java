package com.sparta.jpaadvance.repository;

import com.sparta.jpaadvance.entity.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
