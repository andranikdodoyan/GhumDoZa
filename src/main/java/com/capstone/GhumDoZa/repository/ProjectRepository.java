package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.ProjectEntity;
import com.capstone.GhumDoZa.entity.UserEntity;
import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends
    JpaRepository<ProjectEntity, Long> {

  @NonNull Optional<ProjectEntity> findById(@NonNull Long id);
}
