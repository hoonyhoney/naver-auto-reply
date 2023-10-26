package com.kr.changepoint.autoreply.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Login {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  private String ip;
  private String time;
  @Column(length = 1000)
  private String agent;
  @Column(length = 1000)
  private String refer;
  private Integer count;
  private String replyed;
}
