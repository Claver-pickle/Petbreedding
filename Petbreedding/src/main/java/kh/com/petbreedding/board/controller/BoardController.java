package kh.com.petbreedding.board.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.media.jfxmedia.logging.Logger;

import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.board.model.service.BoardService;
import kh.com.petbreedding.board.model.service.ReviewService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boarService;
		
	//	게시글 목록 + 페이징 + 검색
	@RequestMapping(value = "/fboardlist", method = RequestMethod.GET)
	// TODO 병원 번호, 미용실 번호 GET 방식으로 들고 들어와서 파라미터로 넣어줘야함 - @RequestParam(name="harNum") String harNum
	public ModelAndView fboardlist(Locale locale, ModelAndView mv) {
		List<Board> boardList = boarService.selectBoardList(1, 10);
		mv.addObject("boardList", boardList);
		mv.setViewName("/user/uBoard/fboardList");
		
		return mv;
	}
	
	// 게시글 상세
	@RequestMapping(value = "/fboardcon", method = RequestMethod.GET)
	public ModelAndView fboardcon(
			Locale locale,
			ModelAndView mv,
			@RequestParam(name="boNum") String boNum
			) {
		
		Board board = boarService.selectBoardDetail(boNum);
		System.out.println("컨트롤러 서비스 다녀왔음 : " + board);
		mv.setViewName("/user/uBoard/fboardcon");
		mv.addObject("board", board);
		
		return mv;
	}
	
	@Autowired
	private ReviewService reviewService;
	
	// 리뷰 작성
	// TODO 리뷰 등록 버튼을 눌렀을 때 미용실 또는 병원 번호를 받아와야함
	@RequestMapping(value = "/rwrite", method = RequestMethod.POST)
	public String rwrite(
			Locale locale
			,HttpSession session
			,HttpServletRequest request
			,Client cl
			,@RequestParam(name="revCont") String revCont
			,@RequestParam(name="selectedVal") int revVal
			) {
		System.out.println("리뷰 등록 컨트롤러 진입");
		cl = (Client) session.getAttribute("client");
		String clNum = cl.getCl_num();
		String clNickName = cl.getNickname();
		System.out.println("리퀘스트 겟 파라메타" + request.getParameter("selectedVal"));
		
		Review rv = new Review();
		System.out.println(clNum);
		System.out.println(clNickName);
		System.out.println(revCont);
		
		rv.setClNickName(clNickName.replaceAll("\r\n", "<br>"));
		rv.setClNum(clNum.replaceAll("\r\n", "<br>"));
		rv.setRevCont(revCont);
		rv.setRevVal(revVal);
		
		int result = reviewService.insertReview(rv);
		
		if(result == 1) {
			System.out.println("리뷰 등록 성공");
		} else {
			System.out.println("리뷰 등록 실패");
		}
		
		return "redirect:mypage";
	}
	
	@RequestMapping(value = "/UcustomerService", method = RequestMethod.GET)
	public String UcustomerService(Locale locale, Model model) {
		return "/user/uBoard/UcustomerService";
	}
	@RequestMapping(value = "/bwrite", method = RequestMethod.GET)
	public String bwrite(Locale locale, Model model) {
		return "/user/uBoard/bwrite";
	}
	@RequestMapping(value = "/oftenqna", method = RequestMethod.GET)
	public String oftenqna(Locale locale, Model model) {
		return "/user/uBoard/oftenqna";
	}
	@RequestMapping(value = "/mypet", method = RequestMethod.GET)
	public String mypet(Locale locale, Model model) {
		return "/user/uMyPage/mypet";
	}
	@RequestMapping(value = "/mypetRegister", method = RequestMethod.GET)
	public String mypetRegister(Locale locale, Model model) {
		return "/user/uMyPage/mypetRegister";
	}
	
	@RequestMapping(value = "/myboard", method = RequestMethod.GET)
	public String myboard(Locale locale, Model model) {
		return "/user/uMyPage/myboard";
	}
	@RequestMapping(value = "/myreply", method = RequestMethod.GET)
	public String myreply(Locale locale, Model model) {
		return "/user/uMyPage/myreply";
	}
	
	
	
	
	
	
	

}
