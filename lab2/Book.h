#pragma once
#include <iostream>
#include "Author.h"
#include "Publishinghouse.h"
#include "Review.h"

class Book
{
public:
	Book() {};
	~Book() {};
	void SetPrice(double price);
	void SetTitle(std::string title);
	void SetAuthor(std::string name, std::string lastname, std::string biography);
	void SetPublishinghouse(std::string name, std::string foundationdata);
	void GetInfo();
	double GetPrice();
	void SetReview(Review review);
	double ViewReview();
	std::string GetTitle();
private:
	double price;
	std::string title;
	Author author;
	Publishinghouse house;
	Review review;
};
