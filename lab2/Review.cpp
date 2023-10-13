#include "Review.h"

void Review::WriteReview(double grade, std::string review)
{
	this->grade = grade;
	this->review = review;
}

double Review::ShowReview()
{
	std::cout << author << " " << grade << std::endl;
	std::cout << review << std::endl;
	return grade;
}
