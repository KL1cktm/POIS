#pragma once
#include <iostream>
#include <string>

class Contact
{
public:
	Contact() {};
	~Contact() {};
	void SetEmail(std::string email);
	void SetPhoneNumber(std::string number);
	void SetAddress(std::string address);
	std::string GetEmail();
	std::string GetPhoneNumber();
	std::string GetAddress();
private:
	std::string email;
	std::string number;
	std::string address;
};
