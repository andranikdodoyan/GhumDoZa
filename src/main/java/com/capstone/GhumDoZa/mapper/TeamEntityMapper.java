//package com.capstone.GhumDoZa.mapper;
//
//import com.capstone.GhumDoZa.dto.team.TeamDto;
//import com.capstone.GhumDoZa.entity.TeamEntity;
//import com.capstone.GhumDoZa.entity.relationEntity.TeamUserEntity;
//import com.capstone.GhumDoZa.exception.UserNotFoundException;
//import com.capstone.GhumDoZa.repository.UserRepository;
//import com.capstone.GhumDoZa.repository.relationRepository.TeamUserRepository;
//import java.util.Set;
//import java.util.UUID;
//import java.util.stream.Collectors;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@AllArgsConstructor
//public class TeamEntityMapper {
//
//  private final TeamUserRepository teamUserRepository;
//  private final UserRepository userRepository;
//
//  public TeamDto entityToDto(TeamEntity entity) {
//    Set<UUID> memberIds = teamUserRepository.findAllByTeamId(entity.getId()).stream()
//        .map(TeamUserEntity::getUserId)
//        .collect(Collectors.toSet());
//
//    return TeamDto.builder()
//        .name(entity.getName())
//        .members(
//            memberIds.stream()
//                .map(id -> userRepository.findById(id).orElseThrow(UserNotFoundException::new)
//                    .getId())
//                .map(UUID::toString)
//                .collect(Collectors.toSet())
//        )
//        .build();
//  }
//}
