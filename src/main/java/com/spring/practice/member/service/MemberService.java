package com.spring.practice.member.service;

import com.spring.practice.member.model.dto.MemberDTO;

public interface MemberService {

	void insertMember(MemberDTO memberDTO) throws Exception;

	MemberDTO loginMember(MemberDTO memberDTO) throws Exception;

	void updateMember(MemberDTO memberDTO) throws Exception;

	MemberDTO selectMember(int userId) throws Exception;

	void updatePassword(MemberDTO memberDTO) throws Exception;

	int deleteMember(int userId, String pw) throws Exception;

}
