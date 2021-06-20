package kh.com.petbreedding.mypage.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.petbreedding.mypage.model.vo.MyPet;

public interface MyPetService {
	
	public List<MyPet> selectPetInfo();  // 반려동물 정보 보기
	public void insertPetInfo(MyPet mypet);
	void updatePetInfo(MyPet pet_info); // 반려동물 정보 수정
	void deletePetInfo(MyPet pet_info); // 반려동물 정보 삭제
}
