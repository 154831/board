package com.ktdsuniversity.edu.member.dao;

import com.ktdsuniversity.edu.member.vo.MemberVO;

public interface MemberDao {
	
	/**
	 * 파라미터로 전달 된 이메일이 DB에 몇 건 존재하는 지 확인한다.
	 * @param email 사용자가 가입요청
	 * @return 동일한 이메일로 등록된 회원의 수
	 */
	public int getEmailCount(String email);

	
	
	/**
	 * 회원가입 쿼리를 실행한다.
	 * @param memberVO 사용자가 입력한 회원 정보
	 * @return DB 에 insert 한 갯수
	 */
	public int createNewMember(MemberVO memberVO);

	
	/**
	 * 로그인 시, 비밀번호 암호화를 위해 기존에 발급했던 salt 값을 조회
	 * @param email 조회할 이메일
	 * @return 회원가입 시 발급받은
	 */
	public String getSalt(String email);
	
	/**
	 * 이메일과 비밀번호로 회원을 조회
	 * @param memberVO 이메일과 비밀번호
	 * @return 이메일과 비밀번호가 일치하는 회원의 정보
	 */
	public MemberVO getMember(MemberVO memberVO);
	
	/**
	 * 로그인이 정상적으로 수행되었을 때,
	 * login_cnt는 0으로, latest_login_success는 현재 시간으로
	 * latest_access_ip 는 현재 ip 로 업데이트 한다.
	 * @param memberVO 이메일과 접근  id
	 * @return 업데이트 된 회원 정보의 수
	 */
	public int successLogin(MemberVO memberVO);
	
	/**
	 * 로그인이 실패했을 때, (이메일은 맞지만 비밀번호가 틀린경우)
	 * login_cnt는 1증가하고, 
	 * lATEST_LOGIN_FAIL_DATE는 현재시간으로
	 * LATEST_ACCESS_IP는 현재 ip로 변경한다.
	 * @param memberVO 메일과 접근IP
	 * @return 업데이트된 회원 정보의 수 
	 */
	public int failLogin (MemberVO memberVO);
	
	/**
	 * 로그인이 3회 실패했을 때 BLOCK_YN을 Y 로 변경한다.
	 * BLOCK_YN이 Y인 회원은 절대 로그인할 수 없다. 
	 * @param email
	 */
	public int blockMember(String email);

	/**
	 * 회원 delete 쿼리를 실행한다.
	 * @param email 삭제할 회원의 이메일
	 * @return DB에 delete한 회원의 개수 
	 */
	public int deleteMe(String email);
}

