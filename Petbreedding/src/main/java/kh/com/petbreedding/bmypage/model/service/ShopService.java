package kh.com.petbreedding.bmypage.model.service;

import java.util.List;

import kh.com.petbreedding.bmypage.model.vo.HairDayOff;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.HosDayOff;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;

public interface ShopService {
	
	public List<HairSalon> selectHarList(int currentPage, int limit); // 미용실 리스트 조회
	public int insertHarInfo(HairSalon vo);	// 미용실 기본 정보 입력 
	public HairSalon selectHarInfo(String bpId); // 미용실 기본 정보 불러오기
	public int updateHarInfo(HairSalon vo) ; // 미용실 기본 정보 수정
	public int insertHarImg(HairSalonImg vo); // 미용실 이미지 첨부
	public int deleteHarImg(String harNum); // 미용실 이미지 수정 (삭제)
	public int insertNewHarImg(HairSalonImg vo); // 수정된 미용실 이미지 첨부
	public int insertHarDayOff(HairDayOff vo); // 미용실 주휴일 입력
	public int deleteHarDayOff(String harNum); // 미용실 주휴일 수정 (삭제)
	public int insertNewHarDayOff(HairDayOff vo); // 수정된 미용실 주휴일 추가
	
	
	public int insertHosInfo(Hospital vo);	// 동물병원 기본 정보 입력
	public Hospital selectHosInfo(String bpId); //동물병원 기본 정보 불러오기
	public int updateHosInfo(Hospital vo); // 동물병원 기본 정보 수정
	public int insertHosImg(HospitalImg vo); // 동물병원 이미지 첨부
	public int deleteHosImg(String hosNum); // 동물병원 이미지 수정 (삭제) 
	public int insertNewHosImg(HospitalImg vo); // 수정된 동물병원 이미지 추가
	public int insertHosDayOff(HosDayOff vo); // 동물병원 주휴일 입력
	public int deleteHosDayOff(String hosNum); // 동물병원 주휴일 수정 (삭제)
	public int insertNewHosDayOff(HosDayOff vo); // 수정된 동물병원 주휴일 추가
}
