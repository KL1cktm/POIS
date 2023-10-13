#include "Human.h"

void Human::SetName(std::string name)
{
	this->name = name;
}

void Human::SetLastname(std::string lastname)
{
	this->lastname = lastname;
}

void Human::SetAge(int age)
{
	this->age = age;
}

void Human::GetInfo()
{
	std::cout << lastname << " " << name << " " << age << std::endl;
}

std::string Human::GetLastname()
{
	return lastname;
}
