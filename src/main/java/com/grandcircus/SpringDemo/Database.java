package com.grandcircus.SpringDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Database {
	@Autowired
	JdbcTemplate template;
	final List<Item> items = new ArrayList<Item>();
	final List<Account> accounts = new ArrayList<Account>();
	// items
	public List<Item> getAllItems() {
		return template.query("select * from items;", new BeanPropertyRowMapper<Item>(Item.class));
	}
	public List<Item> getAllItems(String filter) {
		final String query = "select * from items WHERE (item_name LIKE '%?%' OR description LIKE '%?%');".replace("?", filter);
		return template.query(query, new BeanPropertyRowMapper<Item>(Item.class));
	}
	public int addItem(Item item) {
		final String query = "insert into items(item_name, description, quantity, price) values(?, ?, ?, ?);";
		return template.update(query, item.getName(), item.getDescription(), item.getQuantity(), item.getPrice());
	}
	public int remItem(int id) {
		final String query = "delete from items where id = ?;";
		return template.update(query, id);
	}
	public boolean remOneItem(Item item) {
		List<Item> items = template.query("select * from items where item_name = '" + item.getName() + "' ;", new BeanPropertyRowMapper<Item>(Item.class));
		items.get(0).setQuantity(items.get(0).getQuantity()-1);
		updateItem(items.get(0));
		return true;
	}
	public int updateItem(Item item) {
		final String query = "update items set item_name = ?, description = ?, quantity = ?, price = ? where item_name = ?;";
		return template.update(query, item.getName(), item.getDescription(), item.getQuantity(), item.getPrice(), item.getName());
	}
	// accounts
	public int addAccount(Account acc) {
		final String query = "insert into users(first_name, last_name, city, address, phone_num, email) values(?, ?, ?, ?, ?, ?);";
		return template.update(query, acc.getFirstName(), acc.getLastName(), acc.getCity(), acc.getAddress(), acc.getPhone(), acc.getEmail());
	}
}