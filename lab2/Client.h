#pragma once
#include <vector>
#include "Book.h"
#include "Human.h"
#include "Contact.h"



class Client : public Human, public Contact
{
public:
	Client();
	~Client() {};
	void SetMoney(double money);
	void SetStatus(bool status);
	void AddBookInList(Book book);
	std::vector<Book> GetList();
	double GetMoney();
	bool GetStatus();
	void WritePromo(std::string promo);
	std::string GetPromo();
	void WriteReview(Book* book, std::string review, double grade);
private:
	std::string promo;
	double money;
	bool status;
	std::vector<Book> books;
};
