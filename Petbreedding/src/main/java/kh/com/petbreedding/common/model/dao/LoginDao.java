package kh.com.petbreedding.common.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.client.model.vo.Client;

@Repository("loginDao")
public class LoginDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 이메일 로그인
	public Client login(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	
	//카카오 로그인
	public int loginKakao(Client client) {
		// TODO Auto-generated method stub
		return 0;
		
	}
	
	//네이버 로그인
	public int loginNaver(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
