package com.simple.contact;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.simple.contact.dao.ConnectionPull;
import com.simple.contact.dao.impl.ContactDao;
import com.simple.contact.entity.Contact;
import com.simple.contact.exception.DaoException;

public class Main {

	private static void createTableIfNotExistsAndDeleteEntries() {
		try (Connection connect = ConnectionPull.getConnectionFromPull(); Statement st = connect.createStatement()) {
			st.execute("CREATE TABLE IF NOT EXISTS Contact "
					+ "(contact_id BIGSERIAL, name VARCHAR(30), surname VARCHAR(30), "
					+ "login VARCHAR(30), email VARCHAR(30), phone VARCHAR(30), primary key(contact_id));");
			st.execute("delete from contact");
			ConnectionPull.returnConnectionToPull(connect);
		} catch (SQLException e) {
			System.err.println("Table Creation Error");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws DaoException {
		
		
		createTableIfNotExistsAndDeleteEntries();
		ContactDao contactManager = new ContactDao();

		Contact ivan = new Contact("Ivan", "Ivanov", "Ivach82", "ivan@mail.ru", "+375251081616");
		Contact ilya = new Contact("Ilya", "Ilyin", "Ilych666", "ilya@mail.ru", "+375256661313");
		Contact yan = new Contact("Yan", "Yanovski", "Yaz123", "yaz@mail.ru", "+375251113322");

		contactManager.save(ivan);
		contactManager.save(ilya);
		contactManager.save(yan);

		printAll(contactManager);

		ivan.setName("Vano");
		ivan.setPhoneNumber("102");

		contactManager.update(ivan);

		System.out.println("-----after changing the contact \"Ivan\"-----");
		printAll(contactManager);

		contactManager.delete(ilya);

		System.out.println("-----after deleting the contact \"Ilya\"-----");
		printAll(contactManager);
	}

	private static void printAll(ContactDao contactManager) throws DaoException {
		for (Contact chel : contactManager.loadAll()) {
			System.out.println(chel);
		}
	}

}
