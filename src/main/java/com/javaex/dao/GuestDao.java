package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//전체리스트 가져오기
	public List<GuestVo> getGuestList() {
		
		List<GuestVo> guestList = sqlSession.selectList("guestbook.selectList");
		
		return guestList;
	}
	
	//방명록 추가
	public int guestInsert(GuestVo guestVo) {
		
		int count = sqlSession.insert("guestbook.guestInsert", guestVo);
		
		return count;
	}
	
	//방명록 추가2
	public int guestInsert2(String name, String password, String content) {
		
		Map<String, Object> guestMap = new HashMap<String, Object>();
		guestMap.put("name", name);
		guestMap.put("password", password);
		guestMap.put("content", content);
		
		int count = sqlSession.insert("guestbook.guestInsert", guestMap);
		
		return count;
	}
	
	//방명록 삭제
	public int guestDelete(int no, String password) {
		
		Map<String, Object> guestMap = new HashMap<String, Object>();
		guestMap.put("no", no);
		guestMap.put("password", password);
		
		int count = sqlSession.delete("guestbook.guestDelete", guestMap);
		
		return count;
	}
	
}
	
	