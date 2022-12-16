package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Contact;
import com.example.repo.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveContact(Contact contact) {
		contact.setActiveSW("Y");
		contactRepository.save(contact);
		if(contact.getContactId()!=null) {
			return "New Contact Saved....";
		}else {
		return "Not Saved Record";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		//contactRepository.findAll();
		return contactRepository.findByActiveSW("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepository.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if(contactRepository.existsById(contact.getContactId())) {
			contactRepository.save(contact);
			return "Contact is updated";
		}
		return "Contact is not updated";
	}

	@Override
	public String deleteContactById(Integer contactId) {
		Optional<Contact> findById = contactRepository.findById(contactId);
		if(findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSW("N");
			contactRepository.save(contact);
			return "Record is deleted successfully";
		}else {
			return "ContactId is not present! ";
		}
		/*
		 * if(contactRepository.existsById(contactId)) {
		 * contactRepository.deleteById(contactId); return "Deleted the contact"; }
		 * return "Give Id is not exists=="+contactId;
		 */
	}

}
