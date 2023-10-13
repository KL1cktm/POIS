#include "Publishinghouse.h"

void Publishinghouse::SetPublishingHouseName(std::string name)
{
	this->publishingHouseName = name;
}

void Publishinghouse::SetFoundationData(std::string data)
{
	this->data = data;
}

std::string Publishinghouse::GetPublishingHouseName()
{
	return publishingHouseName;
}
