package com.kr.changepoint.autoreply.repository;


import com.kr.changepoint.autoreply.domain.Login;
import com.kr.changepoint.autoreply.dto.LoginDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LoginRepository extends JpaRepository<Login,Long>, LoginRepositoryCustom  {
}

