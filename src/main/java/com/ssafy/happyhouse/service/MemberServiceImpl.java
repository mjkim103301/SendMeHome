package com.ssafy.happyhouse.service;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.MemberDao;
import com.ssafy.happyhouse.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberDto login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		MemberDto memberDto = memberDao.getMember(userId);
		
		if(memberDto == null || !memberDto.getUserpwd().equals(userPwd)) {
			return null;
		}
		return memberDto;
	}

	@Override
	public String findMemberPwd(MemberDto member) {
		// TODO Auto-generated method stub
		String userPwd = memberDao.getMemberPwd(member);
		
		if(userPwd == null || userPwd.equals("")) {
			return null;
		}
		return userPwd;
	}

	@Transactional
	@Override
	public void updateMember(MemberDto member) {
		// TODO Auto-generated method stub
		memberDao.updateMember(member);
	}

	@Override
	@Transactional
	public void registerMember(MemberDto member) {
		// TODO Auto-generated method stub
		memberDao.registerMember(member);
	}

	@Override
	public boolean duplicatedIdCheck(String userId) {
		// TODO Auto-generated method stub
		MemberDto memberDto = memberDao.getMember(userId);
		if(memberDto != null) {
			return false;
		}
		return true;
	}
	

}