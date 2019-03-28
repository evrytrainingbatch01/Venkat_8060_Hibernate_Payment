package com.evry.payment.wallet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.evry.payment.wallet.model.Customer;
import com.evry.payment.wallet.model.CustomerRegistration;
import com.evry.payment.wallet.model.TransactionDetails;

public class PaymentDao {

	public boolean setData(CustomerRegistration payment) {
		boolean flag = false;
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();

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
		txn.commit();
		flag = true;
		factory.close();
		session.close();
		return flag;
	}

	public int getMenu(String name, String pwd) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("fname", name));
		cr.add(Restrictions.eq("pwd", pwd));
		List<Customer> results = cr.list();

		factory.close();
		session.close();
		return results.get(0).getId();
	}

	public boolean setBalance(int id, int money) {
		boolean flag = false;
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
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

	public boolean sendMoney(int sid, int did, int money) {
		boolean flag = false;
		int balance = getBalance(sid);
		if (balance >= money) {
			balance = balance - money;
			if (setAmount(sid, did, balance, money)) {
				flag = true;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	private boolean setAmount(int sid, int did, int balance, int money) {
		boolean flag = false;
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Query qry = session.createQuery("UPDATE Customer c SET c.balance =:balance where c.id =:id");
		qry.setParameter("balance", balance);
		qry.setParameter("id", sid);
		if (qry.executeUpdate() == 1) {
			if (transferToPayee(did, money)) {
				flag = true;
			}
		}

		factory.close();
		session.close();

		return flag;
	}

	private boolean transferToPayee(int did, int money) {

		boolean flag = false;
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();

		TransactionDetails details = new TransactionDetails();
		details.setId(did);
		details.setTransfer_amount(money);

		session.save(details);
		txn.commit();
		flag = true;
		factory.close();
		session.close();
		return flag;

	}

	public int getBalance(int sid) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("id", sid));
		List<Customer> results = cr.list();

		factory.close();
		session.close();
		return results.get(0).getBalance();
	}

	public boolean approveMoney(int id) {
		int balance = getBalance(id);
		int amount = getCustomerAmount(id);
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Query qry = session.createQuery("UPDATE Customer c SET c.balance =:balance where c.id =:id");
		qry.setParameter("balance", balance + amount);
		qry.setParameter("id", id);
		int result = qry.executeUpdate();
		factory.close();
		session.close();
		return (result == 1) ? true : false;
	}

	private int getCustomerAmount(int id) {
		boolean flag = false;
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Query qry = session.createQuery("SELECT sum(process_amount) from TransactionDetails where id =:id")
				.setParameter("id", id);
		List result = qry.list();

		factory.close();
		session.close();

		return Integer.parseInt(result.get(0).toString());
	}

	public boolean sendMoney(int id) {
		int balance = getBalance(id);
		int amount = getTransferAmount(id);
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Query qry = session.createQuery("UPDATE Customer c SET c.balance =:balance where c.id =:id");
		qry.setParameter("balance", balance + amount);
		qry.setParameter("id", id);
		int result = qry.executeUpdate();
		factory.close();
		session.close();
		return (result == 1) ? true : false;
	}

	private int getTransferAmount(int id) {
		boolean flag = false;
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Query qry = session.createQuery("SELECT sum(transfer_amount) from TransactionDetails where id =:id")
				.setParameter("id", id);
		List result = qry.list();

		factory.close();
		session.close();

		return Integer.parseInt(result.get(0).toString());
	}

}
