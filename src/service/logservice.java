package service;

import com.model.logDTO;
import com.repository.logDAO;

public class logservice {


public void clothesclicked(int member_num, int product_num) {
	logDAO dao = new logDAO();
	logDTO dto = new logDTO(1,member_num,product_num);
	
	if(dao.logcheck(dto)==null) {
		dao.insert_log(dto);
	}else {
		dao.logupdate(dto);
		
		System.out.println("?");
	}
	
}

}