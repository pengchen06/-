package jdbc.services;

import java.util.List;

import jdbc.dao.Jdbc_userDao;
import jdbc.entity.Jdbc_userEntity;

public class Jdbc_userService {
     Jdbc_userDao dao=new Jdbc_userDao();
     
     
     /**
      * 调用 Jdbc_userDao中的查询方法,返回list
      * @param address_id
      * @return
      */
     public  List<Jdbc_userEntity> select( int address_id){
    	 return dao.select(address_id);
     }
}
