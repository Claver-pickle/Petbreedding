package kh.com.petbreedding.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.Notice;

@Repository("noticeDao")
public class NoticeDao {

	@Autowired
	private SqlSession sqlSession;

	// 알림 목록 가져오기
	public List<Notice> getNoticeList(String notReceiver) {
		return sqlSession.selectList("notice.getNoticeList", notReceiver);
	}
	
	// bp_id 찾기(예약에서)
	public String getbp_id(String shopNum) {
		return sqlSession.selectOne("notice.getbp_id", shopNum);
	}
	
	// bp_id 찾기(결제에서)
	public String getbp_idforPay(String revNum) {
		return sqlSession.selectOne("notice.getbp_idforPay", revNum);
	}

	// 예약시
	public int inReservaion(Notice notice) {
		return sqlSession.insert("notice.inReservaion", notice);
	}

	// 결제시
	public int inPay(Notice notice) {
		return sqlSession.insert("notice.inPay", notice);
	}

	// 읽지 않은 채팅이 있을 시
	public int inUnreadChat(Notice notice) {
		return sqlSession.insert("notice.inUnreadChat", notice);
	}
	
	// 글번호로 글 작성자 찾기
	public String getOrigClNum(String boNum) {
		return sqlSession.selectOne("notice.getOrigClNum", boNum);
	}

	// 내 글에 댓글이 달렸을 시
	public int inBoard(Notice notice) {
		return sqlSession.insert("notice.inBoard", notice);
	}

	// 내 문의에 답변이 왔을 시
	public int inQna(Notice notice) {
		return sqlSession.insert("notice.inQna", notice);
	}

	// 포인트 적립 시
	public int inPointSave(Notice notice) {
		return sqlSession.insert("notice.inPointSave", notice);
	}

	// 포인트 사용 시
	public int inPointUsing(Notice notice) {
		return sqlSession.insert("notice.inPointUsing", notice);
	}

	// 알림 페이지에 들어가면 읽음으로 처리
	public int updateReadState(String notNum) {
		return sqlSession.update("notice.updateReadState", notNum);
	}

	// 알림 삭제
	public int deleteNotice(String notNum) {
		return sqlSession.delete("notice.deleteNotice", notNum);
	}

}
