package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.UserEntity;
import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
    JpaRepository<UserEntity, Long> {

  @NonNull Optional<UserEntity> findById(@NonNull Long id);
}
