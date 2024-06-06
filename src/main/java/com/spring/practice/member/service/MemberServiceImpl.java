package com.spring.practice.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.practice.member.model.dao.MemberDAO;
import com.spring.practice.member.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private final MemberDAO memberDAO;
	//--------------------------------------------------------- // @Autowired 생략 가능
	 public MemberServiceImpl(MemberDAO memberDAO) {
		 this.memberDAO = memberDAO; 
	 }

	@Override
	public void insertMember(MemberDTO memberDTO) throws Exception {
		
		System.out.println("암호화 전 pw: " + memberDTO.getPw());
		
		String encPw = bCryptPasswordEncoder.encode(memberDTO.getPw());
		
		System.out.println("암호화 후 pw: " + encPw);
		
		memberDTO.setPw(encPw);
		
		int result = memberDAO.insertMember(sqlSession, memberDTO);
		
		if(result < 0) {
			
			throw new Exception("회원 가입에 실패하였습니다.");
			
		}
		
	}

	@Override
	public MemberDTO loginMember(MemberDTO memberDTO) throws Exception {
		
		MemberDTO loginUser = memberDAO.loginMember(sqlSession, memberDTO);
		
		if(loginUser == null) {
			
			throw new Exception("로그인 유저 정보가 없습니다.");
			
		}
		
		if(!bCryptPasswordEncoder.matches(memberDTO.getPw(), loginUser.getPw())) {
			
			throw new Exception("암호 불일치!");
			
		}
		
		System.out.println("로그인에 성공한 유저는: " + loginUser);
		
		return loginUser;
	
	}

}
