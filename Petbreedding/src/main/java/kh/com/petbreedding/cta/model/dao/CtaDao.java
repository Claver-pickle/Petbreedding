package kh.com.petbreedding.cta.model.dao;

import java.util.List;


import kh.com.petbreedding.cta.model.vo.Cta;
import kh.com.petbreedding.cta.model.vo.CtaPay;

public interface CtaDao {
	
	public List<Cta> listAll() throws Exception;
	public Cta read(String CM_TYPE) throws Exception;
	public int insertpay(CtaPay pay) throws Exception;
	public int insertCta(CtaPay pay) throws Exception;
}