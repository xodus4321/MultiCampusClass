package com.multi.erp;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
//단위테스트를 스프링과 연동하기
//@RunWith은 단위테스트의 실행방법을 확장할 때 사용하는 어노테이션으로 ()안에 정의하는 클래스를 실행해서 단위테스트 = >스프링과 연동해서 단위테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/spring-config.xml"})
@WebAppConfiguration
public class SpringJUnitTest01 {
	@Autowired
	DataSource ds;
	@Test
	public void test() {
		assertNotNull(ds);
	}

}
