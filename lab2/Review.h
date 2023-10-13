#pragma once
#include <iostream>
#include <vector>
#include <string>

class Review
{
public:
	Review() { this->grade = 0; };
	~Review() {};
	void WriteReview(double grade, std::string review);
	double ShowReview();
private:
	double grade;
	std::string review;
	std::string author;
};