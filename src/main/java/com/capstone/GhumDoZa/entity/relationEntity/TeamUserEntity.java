//package com.capstone.GhumDoZa.entity.relationEntity;
//
//import com.capstone.GhumDoZa.enums.UserRole;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import java.util.UUID;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Table(name = "team_user", schema = "public")
//@Entity
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class TeamUserEntity {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.UUID)
//  @Column(name = "id", nullable = false)
//  private UUID id;
//
//  @Column(name = "team_id", nullable = false)
//  private UUID teamId;
//
//  @Column(name = "user_id", nullable = false)
//  private UUID userId;
//
//  @Column(name = "role")
//  @Enumerated(EnumType.STRING)
//  private UserRole role;
//}
