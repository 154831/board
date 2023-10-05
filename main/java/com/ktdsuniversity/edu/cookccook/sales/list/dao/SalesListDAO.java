package com.ktdsuniversity.edu.cookccook.sales.list.dao;

import com.ktdsuniversity.edu.cookccook.sales.list.vo.SalesListVO;
import java.util.List;

public interface SalesListDAO {
	
	
	// 상품 검색
	public SalesListVO getSearchProduct (String recipeName);
	
	// 판매 상품 전체 조회 
	public List<SalesListVO> getAllProducts();
	
	// 판매 상품 단건 조회
	public SalesListVO getOneProduct(int id);
	
	// 베스트 레시피와 연관된 상품을 조회
		//일간 구매 순위 조회 
	

}
