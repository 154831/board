package com.ktdsuniversity.edu.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.member.vo.MemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int getEmailCount(String email) {
		return getSqlSession().selectOne("getEmailCount", email);
		
	}
	
	@Override
	public int createNewMember(MemberVO memberVO) {
		return getSqlSession().insert("createNewMember", memberVO);
	}

	@Override
	public String getSalt(String email) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("getSalt", email);
	}

	@Override
	public MemberVO getMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("getMember", memberVO);
	}

	
	@Override
	public int successLogin(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return getSqlSession().update("successLogin", memberVO);
	}

	@Override
	public int failLogin(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return getSqlSession().update("failLogin", memberVO);
	}
	@Override
	public int blockMember(String email) {
		// TODO Auto-generated method stub
		return getSqlSession().update("blockMember", email);
	}

	@Override
	public int deleteMe(String email) {
		// TODO Auto-generated method stub
		return getSqlSession().delete("deleteMe", email);
	}
}
