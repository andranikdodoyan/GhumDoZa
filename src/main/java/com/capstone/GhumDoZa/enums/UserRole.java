package com.capstone.GhumDoZa.enums;

import lombok.Getter;

@Getter
public enum UserRole {
  DEV("Developer"),
  MANAGER("Manager"),
  QA("QA Specialist"),
  DESIGNER("Designer");

  final String name;

  UserRole(String name) {
    this.name = name;
  }
}
