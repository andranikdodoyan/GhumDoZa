package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.CommentEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends
    JpaRepository<CommentEntity, UUID> {

  @NonNull Optional<CommentEntity> findById(@NonNull UUID id);

  List<CommentEntity> findAllByTicketId(UUID ticketId);
}
