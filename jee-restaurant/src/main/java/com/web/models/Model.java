package com.web.models;

import java.io.Serializable;
import java.util.ArrayList;

import metier.entities.Customer;
import metier.entities.Menu;
import metier.entities.MenuType;
import metier.entities.Order;
import metier.entities.OrderDetails;
import metier.entities.Payment;
import metier.entities.Rating;
import metier.entities.SiteInfo;
import metier.entities.User;

public class Model implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private ArrayList<Customer> list_customers;
	private ArrayList<Menu> list_menus;
	private ArrayList<MenuType> list_menu_types;
	private ArrayList<Order> list_orders;
	private ArrayList<OrderDetails> list_order_details;
	private ArrayList<Payment> list_payments;
	private ArrayList<Rating> list_ratings;
	private ArrayList<SiteInfo> list_site_infos;
	private ArrayList<User> list_users;
	
	
	public Model() {
		super();
	}

	public Model(ArrayList<Customer> list_customers, ArrayList<Menu> list_menus, ArrayList<MenuType> list_menu_types,
			ArrayList<Order> list_orders, ArrayList<OrderDetails> list_order_details, ArrayList<Payment> list_payments,
			ArrayList<Rating> list_ratings, ArrayList<SiteInfo> list_site_infos, ArrayList<User> list_users) {
		super();
		this.list_customers = list_customers;
		this.list_menus = list_menus;
		this.list_menu_types = list_menu_types;
		this.list_orders = list_orders;
		this.list_order_details = list_order_details;
		this.list_payments = list_payments;
		this.list_ratings = list_ratings;
		this.list_site_infos = list_site_infos;
		this.list_users = list_users;
	}

	public ArrayList<Customer> getList_customers() {
		return list_customers;
	}

	public void setList_customers(ArrayList<Customer> list_customers) {
		this.list_customers = list_customers;
	}

	public ArrayList<Menu> getList_menus() {
		return list_menus;
	}

	public void setList_menus(ArrayList<Menu> list_menus) {
		this.list_menus = list_menus;
	}

	public ArrayList<MenuType> getList_menu_types() {
		return list_menu_types;
	}

	public void setList_menu_types(ArrayList<MenuType> list_menu_types) {
		this.list_menu_types = list_menu_types;
	}

	public ArrayList<Order> getList_orders() {
		return list_orders;
	}

	public void setList_orders(ArrayList<Order> list_orders) {
		this.list_orders = list_orders;
	}

	public ArrayList<OrderDetails> getList_order_details() {
		return list_order_details;
	}

	public void setList_order_details(ArrayList<OrderDetails> list_order_details) {
		this.list_order_details = list_order_details;
	}

	public ArrayList<Payment> getList_payments() {
		return list_payments;
	}

	public void setList_payments(ArrayList<Payment> list_payments) {
		this.list_payments = list_payments;
	}

	public ArrayList<Rating> getList_ratings() {
		return list_ratings;
	}

	public void setList_ratings(ArrayList<Rating> list_ratings) {
		this.list_ratings = list_ratings;
	}

	public ArrayList<SiteInfo> getList_site_infos() {
		return list_site_infos;
	}

	public void setList_site_infos(ArrayList<SiteInfo> list_site_infos) {
		this.list_site_infos = list_site_infos;
	}

	public ArrayList<User> getList_users() {
		return list_users;
	}

	public void setList_users(ArrayList<User> list_users) {
		this.list_users = list_users;
	}
}
