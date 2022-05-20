package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.mapper.BoardMapper;
import com.study.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void enroll(BoardVO board) {
		mapper.enroll(board);
	}
	
	/* 게시판 목록 */
	@Override
	public List<BoardVO> getList(){
		return mapper.getList();
	}
	
	/* 게시판 조회 */
	@Override
	public BoardVO getPage(int bno) {
		return mapper.getPage(bno);
	}
	
	/* 게시판 수정 */
	@Override
	public int modify(BoardVO board) {
		return mapper.modify(board);
	}
	

}
