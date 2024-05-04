package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
    JpaRepository<UserEntity, UUID> {

  @NonNull Optional<UserEntity> findById(@NonNull UUID id);

  Optional<UserEntity> findByLogin(String login);
}
