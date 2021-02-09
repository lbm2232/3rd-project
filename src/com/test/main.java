package com.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.model.ProductDTO;
import com.repository.ProductDAO;

public class main {

	public static void main(String[] args) {
		
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();
		//dao.put_product(dto);
		
		//ArrayList<ProductDTO> list = dao.All(); // 데이터 전체출력
		ArrayList<ProductDTO> list = dao.select_by_name("나이키","T");//이름에 a들어가는 데이터 출력 
	
		for(ProductDTO d : list) {
			System.out.println(d);
		}
		
			
	}

}


