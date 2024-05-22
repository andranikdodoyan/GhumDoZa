package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.ProjectEntity;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends
    JpaRepository<ProjectEntity, UUID> {

  @NonNull Optional<ProjectEntity> findById(@NonNull UUID id);

  @Query(value = """
      SELECT p.*
      FROM project p
      WHERE p.id IN (SELECT pu.project_id
                           FROM project_team
                                    LEFT JOIN project_user pu ON p.id = pu.project_id
                           WHERE pu.user_id = ?1) OR p.creator_id=?1""", nativeQuery = true)
  Set<ProjectEntity> findProjectsOfUserWithId(@NonNull UUID id);

  Optional<ProjectEntity> findByCode(String code);
}
