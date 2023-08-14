package com.example.service;

import com.example.models.PhoneBook;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneBookServiceImpl implements PhoneBookService{
    private List<PhoneBook> phoneBooks;
    private int newId = 1;
    @Override
    public PhoneBook getPhoneBook(int id) {
        PhoneBook phoneBook = null;
        if (phoneBooks == null) {
            phoneBook = new PhoneBook();
        } else {
            for (var item: phoneBooks ) {
                if (item.getPhoneBookID() == id) {
                    phoneBook = item;
                    break;
                }
            }

            if (phoneBook == null) {
                phoneBook = new PhoneBook();
            }
        }
        return phoneBook;
    }
    @Override
    public List<PhoneBook> getPhoneBooks() {
        if (phoneBooks == null) {
            phoneBooks = new ArrayList<>();
            PhoneBook phoneBook = new PhoneBook(newId++, "Иванов", "Иван", "Иванович",
                "+7(919)154-56-78", "ул. Ленина 1, 15", "рабочий");
            phoneBooks.add(phoneBook);
            phoneBook = new PhoneBook(newId++, "Петров", "Пётр", "Петрович",
                "+7(919)154-56-79", "ул. Петрова 7, 3", "рабочий");
            phoneBooks.add(phoneBook);
            phoneBook = new PhoneBook(newId++, "Сидоров", "Сидор", "Сидорович",
                "+7(919)154-56-80", "ул. Пушкина 4, 1", "рабочий");
            phoneBooks.add(phoneBook);
        }
        return phoneBooks;
    }
    @Override
    public void editRecordToPhoneBooks(PhoneBook newPhoneBook){
        PhoneBook phoneBook = null;
        if (phoneBooks == null) {
            return;
        } else {
            for (var item: phoneBooks ) {
                if (item.getPhoneBookID() == newPhoneBook.getPhoneBookID()) {
                    item.setFirstName(newPhoneBook.getFirstName());
                    item.setLastName(newPhoneBook.getLastName());
                    item.setThreeName(newPhoneBook.getThreeName());
                    item.setNumberPhone(newPhoneBook.getNumberPhone());
                    item.setAddress(newPhoneBook.getAddress());
                    item.setDescription(newPhoneBook.getDescription());
                    break;
                }
            }
        }
    }
    @Override
    public void deleteRecordToPhoneBooks(int id){
        PhoneBook phoneBook = null;
        if (phoneBooks == null) {
            return;
        } else {
            for (var item: phoneBooks ) {
                if (item.getPhoneBookID() == id) {
                    phoneBook = item;
                    break;
                }
            }
            if (phoneBook != null) {
                phoneBooks.remove(phoneBook);
            }
        }
    }
    @Override
    public PhoneBook getNewPhoneBook() {
        return new PhoneBook();
    }
    @Override
    public void addRecordToPhoneBooks(PhoneBook newPhoneBook) {
        newPhoneBook.setPhoneBookID(newId++);
        phoneBooks.add(newPhoneBook);
    }
}

