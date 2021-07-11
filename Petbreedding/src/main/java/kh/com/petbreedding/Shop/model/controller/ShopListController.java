package kh.com.petbreedding.Shop.model.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.Shop.model.service.ShopListService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.common.model.service.LikesService;
import kh.com.petbreedding.common.model.vo.Pagination;

@Controller
public class ShopListController {

	@Autowired
	private ShopListService shopListService;
	
	@Autowired
	private LikesService likeService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	// 사업장 전체 리스트  정렬
	@RequestMapping(value = "/shopList/all", method = RequestMethod.GET)
	public ModelAndView allShopList(
			ModelAndView mv
			,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam Long shopType
			, HttpServletRequest request
			) throws Exception {
		
		// shopType 0은 미용실, 1은 동물병원
		
		if (shopType == 0) {
			
			
			// 미용실 전체 리스트 카운팅
			int total = shopListService.countALLHarList();
			
			
			page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			mv.addObject("paging", page);
			
			
			List<HairSalon> allHarListNew = shopListService.selectAllHarListNew(page);
			System.out.println("미용실 전체 리스트 - 최신순 정렬 :: " + allHarListNew);
			
			
			
			
			mv.addObject("allShopListNew", allHarListNew);
			
			
			
			String har_num = null;
			String bpId = null;
			List<String> countList = new ArrayList<String>();
			List<String> avgList = new ArrayList<String>();
			List<String> revCountList = new ArrayList<String>();
			
			for(int i =0; i<allHarListNew.size(); i++) {
	
				// 찜한 숫자 가져오기
				// + 별점 출력 
				
				
				har_num = allHarListNew.get(i).getHarNum();
				bpId = allHarListNew.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList.add(count);
				mv.addObject("new_count", countList);
				
				String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
				avgList.add(revAvg);
				mv.addObject("new_revAvg", avgList);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList.add(revCount);
				mv.addObject("new_revCount", revCountList);
				
				
			}
			
			List<HairSalon> allHarListLike = shopListService.selectAllHarListLike(page);
			System.out.println("미용실 전체 리스트 - 인기순 정렬 :: " + allHarListLike);
			mv.addObject("allShopListLike", allHarListLike);
			List<String> countList2 = new ArrayList<String>();
			List<String> avgList2 = new ArrayList<String>();
			List<String> revCountList2 = new ArrayList<String>();
			
			for(int i =0; i<allHarListLike.size(); i++) {
				
				har_num = allHarListLike.get(i).getHarNum();
				bpId = allHarListLike.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList2.add(count);
				mv.addObject("like_count", countList2);
				
				String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
				avgList2.add(revAvg);
				System.out.println("평균 별점 보여줘!!!!!!!!!!"+revAvg);
				System.out.println(avgList2);
				mv.addObject("like_revAvg", avgList2);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList2.add(revCount);
				mv.addObject("like_revCount", revCountList2);
				
			}
			
			List<HairSalon> allHarListRev = shopListService.selectAllHarListRev(page);
			System.out.println("미용실 전체 리스트 - 별점순 정렬::"+allHarListRev);
			mv.addObject("allHarListRev", allHarListRev);
			List<String> countList3 = new ArrayList<String>();
			List<String> revCountList3 = new ArrayList<String>();
			
			for(int i=0; i<allHarListRev.size();i++) {
				har_num = allHarListRev.get(i).getHarNum();
				bpId = allHarListRev.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList3.add(count);
				mv.addObject("rev_count", countList3);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList3.add(revCount);
				mv.addObject("rev_revCount", revCountList3);
			}
			
			
		}
				mv.setViewName("/user/uShop/shopList");
				
				return mv;
		
	}
	
	// 사업장 검색 결과 정렬
	@RequestMapping(value = "/shopList/search", method = RequestMethod.GET)
	public ModelAndView searchShopList(
			ModelAndView mv
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam(value="shopType") Long shopType
			,@RequestParam (value="selectlocCon") String searchLoc1
			,@RequestParam (value="selectChooseLoc") String searchLoc2
			,@RequestParam(value="keyword", defaultValue="") String keyword
			, HttpServletRequest request
			) throws Exception{
		
		
		// 미용실(0)
		
		if(shopType==0) {
		
			// 키워드+위치 검색한 경우 
			 if(keyword!="") {
				 System.out.println("설정한 주소는????"+searchLoc1+searchLoc2);
				 System.out.println("검색한 키워드는????"+keyword);
				 mv.addObject("keyword", keyword);
				 mv.addObject("searchLoc1", searchLoc1);
				 mv.addObject("searchLoc2", searchLoc2);
				 
				 Map<String,Object> map1 = new HashMap<String,Object>();
				 map1.put("searchLoc1", searchLoc1);
				 map1.put("searchLoc2", searchLoc2);
				 map1.put("keyword", keyword);
				 
				 
				 // 검색 결과 카운팅
				 
				 int total1 = shopListService.countKeywordHarList();
				 System.out.println("검색된 미용실은 몇 개???"+total1);
				 
				 Pagination page1 = null;
				 page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
				 mv.addObject("keyword_paging", page1);
				 
				 int start1 = page1.getStart();
				 int end1 = page1.getEnd();
				 map1.put("start", start1);
				 map1.put("end", end1);
				 System.out.println("위치 키워드 페이징 map 정보 보여줘~~"+map1);
				 
				 
				 // 키워드 위치 검색 미용실 최신순 정렬
				 List<HairSalon> keywordHarListNew = shopListService.selectKeywordHarListNew(map1);
				 System.out.println("위치로 검색한 미용실 최신순으로 정렬해줘!!!:"+keywordHarListNew);
				 mv.addObject("keywordHarListNew", keywordHarListNew);
				 
				 	String har_num = null;
					String bpId = null;
					List<String> countList1 = new ArrayList<String>();
					List<String> avgList1 = new ArrayList<String>();
					List<String> revCountList1 = new ArrayList<String>();
					
					for(int i =0; i<keywordHarListNew.size(); i++) {
			
						// 찜한 숫자 가져오기
						// + 별점 출력 
						har_num = keywordHarListNew.get(i).getHarNum();
						bpId = keywordHarListNew.get(i).getBpId();
						
						String count = likeService.countSalon(har_num); //찜
						countList1.add(count);
						mv.addObject("keyword_new_count", countList1);
						
						String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
						avgList1.add(revAvg);
						mv.addObject("keyword_new_revAvg", avgList1);
						
						String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
						revCountList1.add(revCount);
						mv.addObject("keyword_new_revCount", revCountList1);
					}
					
					
			 }
			
			// 위치만 설정한 경우
			if(keyword=="") {
				System.out.println("검색한 주소는????"+searchLoc1+searchLoc2);
				
				
				Map<String,Object> map1 = new HashMap<String,Object>();
				 map1.put("searchLoc1", searchLoc1);
				 map1.put("searchLoc2", searchLoc2);
				 
				// 검색 결과 카운팅
					int total1 = shopListService.countHarListLocNew(map1); 
					System.out.println("미용실 검색 결과 개수는?"+total1);
					Pagination page1 = null;
					page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
					mv.addObject("loc_paging", page1);
					int start1 = page1.getStart();
					int end1 = page1.getEnd();
					map1.put("start", start1);
					map1.put("end", end1);
					mv.addObject("map1", map1);
					System.out.println("map 정보 보여줘 !!!!!!!!"+map1);
			
					
			// 미용실 위치 검색 최신순 정렬		 
			 List<HairSalon> harListLocNew = shopListService.selectHarListLocNew(map1);
			 System.out.println("위치로 검색한 미용실 최신순으로 정렬해줘!!!:"+harListLocNew);
			 mv.addObject("harListLocNew", harListLocNew);
			 
			 	String har_num = null;
				String bpId = null;
				List<String> countList = new ArrayList<String>();
				List<String> avgList = new ArrayList<String>();
				List<String> revCountList = new ArrayList<String>();
				
				for(int i =0; i<harListLocNew.size(); i++) {
		
					// 찜한 숫자 가져오기
					// + 별점 출력 
					har_num = harListLocNew.get(i).getHarNum();
					bpId = harListLocNew.get(i).getBpId();
					
					String count = likeService.countSalon(har_num); //찜
					countList.add(count);
					mv.addObject("loc_new_count", countList);
					
					String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
					avgList.add(revAvg);
					mv.addObject("loc_new_revAvg", avgList);
					
					String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
					revCountList.add(revCount);
					mv.addObject("loc_new_revCount", revCountList);
				}
				
				

				// 미용실 위치 검색 결과 인기순 정렬 
					
				 List<HairSalon> harListLocLike = shopListService.selectHarListLocLike(map1);
				 System.out.println("위치로 검색한 미용실 인기순으로 정렬해줘!!!:"+harListLocLike);
				 mv.addObject("harListLocLike", harListLocLike);
				
					List<String> countList2 = new ArrayList<String>();
					List<String> avgList2 = new ArrayList<String>();
					List<String> revCountList2 = new ArrayList<String>();
				
					for(int i =0; i<harListLocLike.size(); i++) {
						
						// 찜한 숫자 가져오기
						// + 별점 출력 
						har_num = harListLocLike.get(i).getHarNum();
						bpId = harListLocLike.get(i).getBpId();
						
						String count = likeService.countSalon(har_num); //찜
						countList2.add(count);
						mv.addObject("loc_like_count", countList2);
						
						String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
						avgList2.add(revAvg);
						mv.addObject("loc_like_revAvg", avgList2);
						
						String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
						revCountList2.add(revCount);
						mv.addObject("loc_like_revCount", revCountList2);
					}
					
					
				// 미용실 위치 검색 결과 별점순 정렬
				List<HairSalon> harListLocRev = shopListService.selectHarListLocRev(map1);
				System.out.println("위치로 검색한 미용실 별점순으로 정렬해줘!!!!"+harListLocRev);
				mv.addObject("harListLocRev", harListLocRev);
				
				List<String> countList3 = new ArrayList<String>();
				List<String> revCountList3 = new ArrayList<String>();
				
				for(int i =0; i<harListLocRev.size(); i++) {
					
					// 찜한 숫자 가져오기
					// + 별점 출력 
					har_num = harListLocRev.get(i).getHarNum();
					bpId = harListLocRev.get(i).getBpId();
					
					String count = likeService.countSalon(har_num); //찜
					countList3.add(count);
					mv.addObject("loc_rev_count", countList3);
					System.out.println("찜수 리스트 보여줘**********"+countList3);
					
					String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
					revCountList3.add(revCount);
					System.out.println("리뷰 개수 리스트 보여주ㅝ*****"+revCountList3);
					mv.addObject("loc_rev_revCount", revCountList3);
				}
			}
			
			
		}
		
		mv.setViewName("/user/uShop/shopList");
		return mv;
		
		 
		 
		 
		
	}
	
}
