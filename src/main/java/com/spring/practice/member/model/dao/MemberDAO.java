package com.spring.practice.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring.practice.member.model.dto.MemberDTO;

@Repository
public class MemberDAO {


	public int insertMember(SqlSessionTemplate sqlSession, MemberDTO memberDTO) {
		
		return sqlSession.insert("memberMapper.insertMember", memberDTO);
		
	}
	
	public MemberDTO loginMember(SqlSessionTemplate sqlSession, MemberDTO memberDTO) {
		
		return sqlSession.selectOne("memberMapper.loginMember", memberDTO);
		
	}

	public int updateMember(SqlSessionTemplate sqlSession, MemberDTO memberDTO) {
		
		return sqlSession.update("memberMapper.updateMember", memberDTO);

	}
	
	public int updatePassword(SqlSessionTemplate sqlSession, MemberDTO memberDTO) {
		
		return sqlSession.update("memberMapper.updatePassword", memberDTO);
	}

	public int deleteMember(SqlSessionTemplate sqlSession, int userId) {

		return sqlSession.delete("memberMapper.deleteMember", userId);
		
	}

	public MemberDTO selectMember(SqlSessionTemplate sqlSession, int UserId) {
		
		return sqlSession.selectOne("memberMapper.selectMember", UserId);
		
	}

	public List<MemberDTO> selectList(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectList("memberMapper.selectList");
		
	}


	

	
	

	
	
}
