#include "Client.h"

Client::Client()
{
	this->money = 0;
}

void Client::SetMoney(double money)
{
	this->money = money;
}

void Client::SetStatus(bool status)
{
	this->status = status;
}

void Client::AddBookInList(Book book)
{
	books.push_back(book);
}

std::vector<Book> Client::GetList()
{
	return books;
}

double Client::GetMoney()
{
	return money;
}

bool Client::GetStatus()
{
	return status;
}

void Client::WritePromo(std::string promo)
{
	this->promo = promo;
}

std::string Client::GetPromo()
{
	return promo;
}

void Client::WriteReview(Book* book, std::string review, double grade)
{
	Review newReview;
	newReview.WriteReview(grade, review);
	(*book).SetReview(newReview);
}
