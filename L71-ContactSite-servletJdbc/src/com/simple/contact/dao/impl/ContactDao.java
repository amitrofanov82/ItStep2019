package com.simple.contact.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.simple.contact.dao.IContactDao;
import com.simple.contact.entity.Contact;
import com.simple.contact.exception.DaoException;

public class ContactDao implements IContactDao {
	
	
	
	//EntityManagerFactory emf = 
			//Persistence.createEntityManagerFactory("PUnitName");;

	@Override
	public Long save(Contact contact) throws DaoException {
		return null;
	}

	@Override
	public void update(Contact contact) throws DaoException {
	}

	@Override
	public List<Contact> loadAll() throws DaoException {
		return null;
	}

	
	public static void main(String[] args) {
		
		//ContactDao cd = new ContactDao();
	}
}









