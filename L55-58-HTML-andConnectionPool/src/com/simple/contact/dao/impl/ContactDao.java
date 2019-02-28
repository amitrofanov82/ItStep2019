package com.simple.contact.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simple.contact.dao.ConnectionPull;
import com.simple.contact.dao.IContactDao;
import com.simple.contact.entity.Contact;
import com.simple.contact.exception.DaoException;

public class ContactDao implements IContactDao {

	private static final String SQL_INSERT_CONTACT_QUERY = "INSERT INTO Contact "
			+ "(name, surname, login, email, phone) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_CONTACT_QUERY = "UPDATE Contact SET name=?, surname=?, "
			+ "login=?, email=?, phone=? WHERE contact_id= ?";
	private static final String SQL_SELECT_ALL_CONTACTS_QUERY = "SELECT * FROM Contact";
	private static final String SQL_SELECT_ALL_ID_QUERY = "SELECT contact_id FROM Contact";

	@Override
	public Long save(Contact contact) throws DaoException {
		Long contactId = 0L;
		try (Connection connect = ConnectionPull.getConnectionFromPull();
				PreparedStatement statement = connect.prepareStatement(SQL_INSERT_CONTACT_QUERY,
						new String[] { "contact_id" });
				Statement st = connect.createStatement()) {
			statement.setString(1, contact.getName());
			statement.setString(2, contact.getSurname());
			statement.setString(3, contact.getLogin());
			statement.setString(4, contact.getEmail());
			statement.setString(5, contact.getPhoneNumber());
			statement.execute();
			st.execute(SQL_SELECT_ALL_ID_QUERY);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				contactId = rs.getLong(1);
			}
			contact.setId(contactId);
			ConnectionPull.returnConnectionToPull(connect);
		} catch (SQLException e) {
			throw new DaoException("Can't add contact " + e.getMessage(), e);
		}
		return contactId;
	}

	@Override
	public void update(Contact contact) throws DaoException {
		try (Connection connect = ConnectionPull.getConnectionFromPull();
				PreparedStatement statement = connect.prepareStatement(SQL_UPDATE_CONTACT_QUERY)) {
			statement.setString(1, contact.getName());
			statement.setString(2, contact.getSurname());
			statement.setString(3, contact.getLogin());
			statement.setString(4, contact.getEmail());
			statement.setString(5, contact.getPhoneNumber());
			statement.setLong(6, contact.getId());
			statement.executeUpdate();
			ConnectionPull.returnConnectionToPull(connect);
		} catch (SQLException e) {
			throw new DaoException("Can't update contact" + e.getMessage(), e);
		}
	}

	@Override
	public List<Contact> loadAll() throws DaoException {
		List<Contact> contacts = new ArrayList<Contact>();
		try (Connection connect = ConnectionPull.getConnectionFromPull();
				Statement statement = connect.createStatement()) {
			ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_CONTACTS_QUERY);
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("contact_id"));
				contact.setName(rs.getString("name"));
				contact.setSurname(rs.getString("surname"));
				contact.setLogin(rs.getString("login"));
				contact.setEmail(rs.getString("email"));
				contact.setPhoneNumber(rs.getString("phone"));
				contacts.add(contact);
			}
			ConnectionPull.returnConnectionToPull(connect);
		} catch (SQLException e) {
			throw new DaoException("Can't load all contacts" + e.getMessage(), e);
		}
		return contacts;
	}

	@Override
	public void delete(Contact contact) {
		try (Connection connect = ConnectionPull.getConnectionFromPull(); Statement st = connect.createStatement()) {
			st.execute("delete from contact where contact_id = " + contact.getId());
			ConnectionPull.returnConnectionToPull(connect);
		} catch (SQLException e) {
			System.out.println("Line delete error!");
		}
	}

}
