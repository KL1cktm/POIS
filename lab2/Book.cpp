#include "Book.h"

void Book::SetPrice(double price)
{
	this->price = price;
}

void Book::SetTitle(std::string title)
{
	this->title = title;
}

void Book::SetAuthor(std::string name, std::string lastname, std::string biography)
{
	author.SetName(name);
	author.SetLastname(lastname);
	author.SetBiography(biography);
}

void Book::SetPublishinghouse(std::string name, std::string foundationdata)
{
	house.SetPublishingHouseName(name);
	house.SetFoundationData(foundationdata);
}

void Book::GetInfo()
{
	std::cout << "The title: " << title << "\nThe publishing house: " << house.GetPublishingHouseName() << "\nThe author: ";
	author.GetInfo();
	std::cout << "Price: " << price << "$" << std::endl;
}

double Book::GetPrice()
{
	return price;
}

void Book::SetReview(Review review)
{
	this->review = review;
}

double Book::ViewReview()
{
	return review.ShowReview();
}

std::string Book::GetTitle()
{
	return title;
}
