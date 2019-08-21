package com.grandcircus.SpringDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class Database {
	@Autowired
	JdbcTemplate template;
	List<Item> items;
	List<Account> accounts;
	// items
	public List<Item> getAllItems() {
		return template.query("select * from items;", new BeanPropertyRowMapper<Item>(Item.class));
	}
	public int addItem(String name, String description, int quantity, int price) {
		final String query = "insert into items(name, description, quantity, price) values(?, ?, ?, ?);";
		return template.update(query, name, description, quantity, price);
	}
	public int remItem(int id) {
		final String query = "delete from items where id = ?;";
		return template.update(query, id);
	}
	public int updateItem(Item item) {
		final String query = "update food set category = ?, description = ?, name = ? where id = ?;";
		return template.update(query, item.getName(), item.getDescription(), item.getQuantity(), item.getPrice());
	}
	// accounts
	public int addAccount(Account acc) {
		final String query = "insert into users(first_name, last_name, city, address, phone_num, email) values(?, ?, ?, ?, ?, ?);";
		return template.update(query, acc.getFirstName(), acc.getLastName(), acc.getCity(), acc.getAddress(), acc.getPhone(), acc.getEmail());
	}
}