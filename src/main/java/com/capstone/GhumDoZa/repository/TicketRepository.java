package com.capstone.GhumDoZa.repository;

import com.capstone.GhumDoZa.entity.TicketEntity;
import com.capstone.GhumDoZa.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends
    JpaRepository<TicketEntity, UUID> {

  @NonNull Optional<TicketEntity> findById(@NonNull UUID id);
}
