package com.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hiber.PersistantTest;
import com.json.createJSON;

public class FetchUserInfo {
	
 @SuppressWarnings("unchecked")
public FetchUserInfo(String userName)
 {
	 Transaction Tx = null;
	 try{
	 Configuration cfg = new Configuration();
	 cfg.configure("hibernate.cfg.xml");
	 SessionFactory factory = cfg.buildSessionFactory();
	 Session session = factory.openSession();
	  List<PersistantTest> ls = null;
		 Tx = session.beginTransaction();
		 String hql = "from PersistantTest PT where PT.userName ='" +userName+"'";
		 Query query = session.createQuery(hql);
		 ls = query.list();
		
		 if(ls.isEmpty())
		 {
			 System.out.print("No Such Entity");
			 Tx.rollback();
		 }
		 else
		 {
			 new createJSON(ls);
		 /*for(PersistantTest PT : ls)
			 System.out.print(PT.getCity());*/
		 }
		 session.close();
		 factory.close();
	 }
	 catch(HibernateException e)
	 { 
			 
         e.printStackTrace(); 
	 }
	  
	  
 }

}
