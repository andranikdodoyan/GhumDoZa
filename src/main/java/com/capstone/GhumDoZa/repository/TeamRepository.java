package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.TeamEntity;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends
    JpaRepository<TeamEntity, UUID> {

  @NonNull Optional<TeamEntity> findById(@NonNull UUID id);

  @Query(value = """
      SELECT t.*
      FROM team t where id in (Select team_id from team_user where user_id=?1)
      """, nativeQuery = true)
  Set<TeamEntity> findTeamsOfUserWithId(@NonNull UUID id);
}
