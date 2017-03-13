package jdbc.services;

import jdbc.dao.Jdbc_addresDao;
import jdbc.entity.Jdbc_addresEntity;

public class Jdbc_addresService {
      Jdbc_addresDao dao=new Jdbc_addresDao();
      
      
      /**
       * 调用Jdbc_addresDao中的查询方法 返回list
       * @param address_id
       * @return
       */
      public Jdbc_addresEntity select(int address_id){
    	  return dao.select(address_id);
      }
}
