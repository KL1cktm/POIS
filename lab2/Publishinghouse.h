#pragma once
#include <iostream>
#include <string>

class Publishinghouse
{
public:
	Publishinghouse() {};
	~Publishinghouse() {};
	void SetPublishingHouseName(std::string name);
	void SetFoundationData(std::string data);
	std::string GetPublishingHouseName();
private:
	std::string publishingHouseName;
	std::string data;
};
