package com.evry.payment.wallet.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.evry.payment.wallet.model.Customer;
import com.evry.payment.wallet.model.CustomerRegistration;
import com.evry.payment.wallet.model.TransactionDetails;

public class PaymentDao {

	public boolean setData(CustomerRegistration payment) {
		boolean flag = false;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory factory = meta.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer customer = new Customer();
		customer.setId(payment.getId());
		customer.setFname(payment.getFname());
		customer.setLname(payment.getLname());
		customer.setPwd(payment.getPwd());
		customer.setCity(payment.getCity());
		customer.setCountry(payment.getCountry());
		customer.setMobile(payment.getMobile());
		customer.setEmail(payment.getEmail());
		session.save(customer);
		transaction.commit();
		flag = true;
		factory.close();
		session.close();
		return flag;
	}

	public int getMenu(String name, String pwd) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory factory = meta.buildSessionFactory();
		Session session = factory.openSession();
		SQLQuery query = session.createSQLQuery("select id from banking.customer where firstname=? and password=?");
		List<String> rows = query.setString(0, name).setString(1, pwd).list();
		String id = rows.get(0);
		System.out.println(id);
		factory.close();
		session.close();
		return Integer.parseInt(id);
	}

	public boolean setBalance(int id, int money) {
		boolean flag = false;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory factory = meta.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		TransactionDetails details = new TransactionDetails();
		details.setId(id);
		details.setProcess_amount(money);
		session.save(details);
		transaction.commit();
		flag = true;
		factory.close();
		session.close();
		return flag;

	}

}
