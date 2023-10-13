#pragma once
#include <vector>
#include <iostream>
#include <string>
#include "Shedule.h"
#include "Contact.h"
#include "Book.h"
#include "Librarian.h"

class BookWarehouse : public Shedule, public Contact
{
public:
	BookWarehouse() {};
	~BookWarehouse() {};
	Shedule* SetShedule(std::string worktime, std::string workweek);
	void SetWarehouseTitle(std::string title);
	std::string GetWarehouseTitle();
	void AddNewBookInList(Book book);
	std::vector<Book> GetBookList();
	void AddLibrerian(Librarian librarian);
	std::vector<Librarian> ViewStaff();
private:
	std::string warehouseTitle;
	Shedule shedule;
	std::vector<Book> books;
	std::vector<Librarian> librarians;
};
