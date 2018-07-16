package components.daos.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import components.daos.HibernateUtil;
import components.daos.interfaces.GenericDAO;
import components.daos.interfaces.RestaurantDAO;
import model.business.Restaurant;

public class RestaurantDAOImpl implements GenericDAO<Restaurant,Long>, RestaurantDAO{

	@Autowired
	HibernateUtil util;
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Restaurant restaurant) {
		return util.save(restaurant);
	}
	
	@Override
	public boolean update(Restaurant restaurant) {
		return util.modify(restaurant);
		
	}

	@Override
	public boolean remove(Restaurant restaurant) {
		return util.delete(restaurant);
	}

	@Override
	public Restaurant getByID(Long key) {
		//Return the Restaurant that matches the key
		Session session = this.sessionFactory.openSession();
		Restaurant restaurant = null;
		try{
			Transaction tx = session.beginTransaction();
			restaurant = (Restaurant) session.load(Restaurant.class, key);
			tx.commit();
		}catch(Exception e){
			System.out.println("RestaurantDAOImpl: Error loading Restaurant with ID "+key);
		}finally{
			session.close();
		}
		return restaurant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getAll() {
		//Returns a list with all Restaurants
		Session session = this.sessionFactory.openSession();
		
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		try{
			
			restaurants = session.createQuery("from Restaurant").list();
		}catch(Exception e){
			System.out.println("RestaurantDAOImpl: Error retrieving restaurants list");
		}finally{
			session.close();
		}
		return restaurants;
	}

	@Override
	public Restaurant getByName(String name) {
		//Return the Restaurant that matches the name
		Session session = this.sessionFactory.openSession();
		Restaurant restaurant = null;
		try{
			Transaction tx = session.beginTransaction();
			restaurant = (Restaurant) session.createQuery("from Restaurant where name ='"+name+"'");
			tx.commit();
		}catch(Exception e){
			System.out.println("RestaurantDAOImpl: Error loading Restaurant with name "+name);
		}finally{
			session.close();
		}
		return restaurant;
		
	}
}
