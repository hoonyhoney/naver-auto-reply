package com.kr.changepoint.autoreply.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LoginDto {
  private Long id;
  private String time;
  @Column(length = 1000)
  private String refer;
  private String replyed;

  public LoginDto(){
  }

  @QueryProjection
  public LoginDto(Long id,String refer, String replyed){
    this.id = id;
    this.refer=refer;
    this.replyed=replyed;
  }
}
