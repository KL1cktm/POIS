#pragma once
#include <iostream>
#include <string>

class Human
{
public:
	Human() {};
	~Human() {};
	void SetName(std::string name);
	void SetLastname(std::string lsatname);
	void SetAge(int age);
	void GetInfo();
	std::string GetLastname();
protected:
	std::string name;
	std::string lastname;
	int age;
};