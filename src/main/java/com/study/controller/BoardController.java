package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.model.BoardVO;
import com.study.service.BoardService;


@Controller
@RequestMapping("/board/*")
// board로 시작하는 모든 처리를 BoardController가 하게한다는 뜻
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService bservice;
	
	/* 게시판 목록 페이지 접속 
	@GetMapping("/list")*/
	/* => @RequestMapping(value="list", method=RequestMethod.GET) 
	public void boardListGet() {
		log.info("게시판 목록 페이지 진입");
	}
	*/
	
	/* 게시판 등록 페이지 접속 */
	@GetMapping("/enroll")
	/* => @RequestMapping(value="enroll", method=RequestMethod.GET) */
	public void boardEnrollGet() {
		log.info("게시판 등록 페이지 진입");
	}
	
	/* 게시판 등록 */
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardVO : " + board);
		
		bservice.enroll(board);
		
		rttr.addFlashAttribute("result", "등록 성공하였습니다.");
		
		return "redirect:/board/list";
		/* redirect로 목록으로 이동하는 이유는 새로고침을 통해 같은 페이지에서 동일한 내용을 계속 입력 할 수 없게 하기 위해서이다. */
	}
	
	/* 게시판 목록 페이지 접속 */
	@GetMapping("/list")
	public void boardListGET(Model model) {
		log.info("게시판 목록 페이지 접속");
		model.addAttribute("list",bservice.getList());
	}
	
	/* 게시판 조회 */
	@GetMapping("/get")
	public void boardPageGET(int bno,Model model) {
		model.addAttribute("pageInfo",bservice.getPage(bno));
	}
	
	/* 수정페이지 이동 */
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model) {
		model.addAttribute("pageInfo",bservice.getPage(bno));
	}
	
	/* 페이지수정 */
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board,RedirectAttributes rttr) {
		bservice.modify(board);
		rttr.addFlashAttribute("result","Modify Success");
		return "redirect:/board/list";
		
	}
	
}
