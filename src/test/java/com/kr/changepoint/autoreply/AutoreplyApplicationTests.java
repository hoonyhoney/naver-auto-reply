package com.kr.changepoint.autoreply;


import com.kr.changepoint.autoreply.config.QuerydslConfiguration;
import com.kr.changepoint.autoreply.repository.LoginRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

//@SpringBootTest
//@DataJpaTest //통합테스트가 아닌 slice 테스트 방식을 선택
//@ActiveProfiles("prd")
@Transactional
@Import(QuerydslConfiguration.class) //slice 테스트 시 JPAQueryFactory 주입이 안되므로 직접 config import
class AutoreplyApplicationTests {

	@Autowired
	JPAQueryFactory jpaQueryFactory;

	@Autowired
	LoginRepository loginRepository;


	@Test
	void contextLoads() {
	}
	@Test
	void stringBuilder(){
		String s = "https://blog.naver.com/yhm4082/223206553513";
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb.insert(8,"m.");
		System.out.println("sb = " + sb);
	}
}

