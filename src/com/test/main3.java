package com.test;

import java.util.ArrayList;

import com.model.ProductDTO;
import com.model.logDTO;
import com.repository.ProductDAO;
import com.repository.logDAO;

public class main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logDAO dao = new logDAO();
		logDTO dto = new logDTO(1,1,1);
		dao.insert_log(dto); //�α׿� �� �ֱ�
	
		//dao.logcheck(dto);

		// ArrayList<ProductDTO> list = dao.All(); // ������ ��ü���
	
	}
}
