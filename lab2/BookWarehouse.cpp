#include "BookWarehouse.h"

Shedule* BookWarehouse::SetShedule(std::string worktime, std::string workweek)
{
	shedule.SetWorktime(worktime);
	shedule.SetWorkweek(workweek);
	return &shedule;
}

void BookWarehouse::SetWarehouseTitle(std::string title)
{
	this->warehouseTitle = title;
}

std::string BookWarehouse::GetWarehouseTitle()
{
	return warehouseTitle;
}

void BookWarehouse::AddNewBookInList(Book book)
{
	books.push_back(book);
}

std::vector<Book> BookWarehouse::GetBookList()
{
	for (int i = 0; i < books.size(); i++)
	{
		books[i].GetInfo();
	}
	return books;
}

void BookWarehouse::AddLibrerian(Librarian librarian)
{
	librarians.push_back(librarian);
}

std::vector<Librarian> BookWarehouse::ViewStaff()
{
	for (int i = 0; i < librarians.size(); i++)
	{
		librarians[i].GetInfo();
	}
	return librarians;
}


