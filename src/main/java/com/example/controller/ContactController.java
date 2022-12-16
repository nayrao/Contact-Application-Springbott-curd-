package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Contact;
import com.example.service.ContactService;

@RestController
@CrossOrigin
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {
		
		return contactService.saveContact(contact);
		
	}

	@GetMapping("/contacts")
	public List<Contact> getAllContacts(){
		return contactService.getAllContacts();
		
	}
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		return contactService.getContactById(contactId);
		
	}
	
	@PutMapping("/contact")
	public String editContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
		
	}
	
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		return contactService.deleteContactById(contactId);
		
	}
	@GetMapping("/")
	public String welcome() {
		return "Welcome to springboot application.....";
		
		
	}
	
	
}
