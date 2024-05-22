package com.capstone.GhumDoZa.repository.relationRepository;

import com.capstone.GhumDoZa.entity.relationEntity.ProjectUserEntity;
import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectUserRepository extends
    JpaRepository<ProjectUserEntity, UUID> {

  List<ProjectUserEntity> findAllByProjectId(@NonNull UUID projectId);

  boolean existsByProjectIdAndUserId(UUID projectId, UUID userId);
}
