package com.study.persistance;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

	public class JdbcTest {
		 static { 
		        try { 
		            Class.forName("com.mysql.cj.jdbc.Driver"); 
		        } catch(Exception e) { 
		            e.printStackTrace(); 
		        } 
		    } 
		    
		    @Test 
		    public void testConnection() { 
		        try(Connection con = DriverManager.getConnection( 
		                "jdbc:mysql://localhost:3306/study?serverTimezone=Asia/Seoul",  // study?server 부분에 study는 내가 지정하는 Database
		                "root", 
		                "Jongho89!!")){ //Mysql 비밀번호 입력 
		            System.out.println(con); 
		        } catch (Exception e) { 
		            fail(e.getMessage()); 
		        } 
		    
		    }    
	}


