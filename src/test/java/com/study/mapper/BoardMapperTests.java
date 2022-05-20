package com.study.mapper;

//import org.apache.log4j.Logger;
//import org.apache.log4j.spi.LoggerFactory;
//위의 Logger를 아래와 같이 변경
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
 
     //private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);
     private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);
     @Autowired
     private BoardMapper mapper;
 
     /*
     @Test
     public void testEnroll() {
         
         BoardVO vo = new BoardVO();
         
         vo.setTitle("mapper 작동확인");
         vo.setContent("mapper 작동확인");
         vo.setWriter("mapper 작동확인");
         
         mapper.enroll(vo);
         
     }
     */
     
     /* 게시판 목록 테스트 */
     @Test
     public void testGetList() {
         
         
         List list = mapper.getList();
        /* 일반적 for문 
         for(int i = 0; i < list.size();i++) {
             log.info("" + list.get(i));
         }
         */
         
        /* foreach문(향상된 for문) 
         for(Object a : list) {
             log.info("" + a);
         }
         */
         
        /* foreach문 & 람다식 */
         list.forEach(board -> log.info("" + board));
         
     }
     
     
     @Test
     public void testGetPage() {
    	 /* 실제 존재하는 페이지 */
    	 int bno = 8;
    	 log.info("" + mapper.getPage(bno));
     }
     
     @Test
     public void testModify() {
    	 BoardVO board = new BoardVO();
    	 board.setBno(8);
    	 board.setTitle("수정 제목");
    	 board.setContent("수정 내용");
    	 
    	 int result = mapper.modify(board);
    	 log.info("result : " +result);
     }
}
