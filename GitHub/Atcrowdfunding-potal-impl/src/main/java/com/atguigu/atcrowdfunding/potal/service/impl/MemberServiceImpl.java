package com.atguigu.atcrowdfunding.potal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.exception.LoginFailException;
import com.atguigu.atcrowdfunding.potal.dao.MemberMapper;
import com.atguigu.atcrowdfunding.potal.service.MemberService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper ;

	@Override
	public Member queryMebmerlogin(Map<String, Object> paramMap) {
		Member member = memberMapper.queryMebmerlogin(paramMap);
		if(member==null){
			throw new LoginFailException("�û����벻����!");
		}
		return member;
	}

	@Override
	public void updateAcctType(Member loginMember) {
		memberMapper.updateAcctType(loginMember);
	}

	@Override
	public void updateBasicinfo(Member loginMember) {
		memberMapper.updateBasicinfo(loginMember);
	}

	@Override
	public void updateEmail(Member loginMember) {
		memberMapper.updateEmail(loginMember);
	}

	@Override
	public void updateAuthstatus(Member loginMember) {
		memberMapper.updateAuthstatus(loginMember);
	}

	@Override
	public Member getMemberById(Integer memberid) {
		return memberMapper.getMemberById(memberid);
	}
;
	@Override
	public List<Map<String, Object>> queryCertByMemberid(Integer memberid) {
		return memberMapper.queryCertByMemberid(memberid);
	}

	@Override
	public int saveMember(Member member) {
		member.setUserpswd(MD5Util.digest(Const.PASSWORD));
		return memberMapper.insert(member);
	}





	
	
}
