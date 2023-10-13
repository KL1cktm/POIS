#include "Contact.h"

void Contact::SetEmail(std::string email)
{
	this->email = email;
}

void Contact::SetPhoneNumber(std::string number)
{
	this->number = number;
}

void Contact::SetAddress(std::string address)
{
	this->address = address;
}

std::string Contact::GetEmail()
{
	return email;
}

std::string Contact::GetPhoneNumber()
{
	return number;
}

std::string Contact::GetAddress()
{
	return address;
}
