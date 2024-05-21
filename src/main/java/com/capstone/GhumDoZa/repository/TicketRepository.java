package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.TicketEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends
    JpaRepository<TicketEntity, UUID> {

  @NonNull Optional<TicketEntity> findById(@NonNull UUID id);

  List<TicketEntity> findAllByAssigneeId(UUID assigneeId);
  List<TicketEntity> findAllByProjectId(UUID projectId);
  List<TicketEntity> findByHeadlineLikeIgnoreCase(String headline);
}
