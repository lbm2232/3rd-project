package com.test;

import com.model.ProductDTO;
import com.repository.ProductDAO;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductDAO dao = new ProductDAO();
		ProductDTO dto = new ProductDTO(500,"ㅇ","ㅇ",2);
		dao.put_product(dto); //상품넣기
	}

}
