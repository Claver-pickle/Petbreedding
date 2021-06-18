package kh.com.petbreedding.cta.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.cta.model.vo.Cta;
import kh.com.petbreedding.cta.model.vo.CtaPay;

@Repository("ctaDao")
public class CtaDaoImpl implements CtaDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Cta> listAll() throws Exception {
		return sqlSession.selectList("Cta.ctalist");
	}

	@Override
	public Cta read(String CM_TYPE) throws Exception {
		return sqlSession.selectOne("Cta.ctacon", CM_TYPE);
	}

	@Override
	public int insertpay(CtaPay pay) throws Exception {
		return sqlSession.insert("Cta.paydata", pay);
	}

	@Override
	public int insertCta(CtaPay pay) throws Exception {
		return sqlSession.insert("Cta.insertcta", pay);
	}

}