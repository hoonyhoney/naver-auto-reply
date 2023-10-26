package com.kr.changepoint.autoreply.repository;

import static com.kr.changepoint.autoreply.domain.QLogin.*;

import com.kr.changepoint.autoreply.dto.LoginDto;
import com.kr.changepoint.autoreply.dto.QLoginDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import java.util.ArrayList;
import java.util.List;

public class LoginRepositoryImpl implements LoginRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  public LoginRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

}
