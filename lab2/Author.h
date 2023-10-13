#pragma once
#include <iostream>
#include "Human.h"

class Author : public Human
{
public:
	Author() {};
	~Author() {};
	void SetBiography(std::string biography);
	void GetBiography();
private:
	std::string biography;
};