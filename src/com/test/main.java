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
		
		//ArrayList<ProductDTO> list = dao.All(); // ������ ��ü���
		ArrayList<ProductDTO> list = dao.select_by_name("����Ű","T");//�̸��� a���� ������ ��� 
	
		for(ProductDTO d : list) {
			System.out.println(d);
		}
		
			
	}

}


