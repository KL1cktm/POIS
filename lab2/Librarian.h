#pragma once
#include "Human.h"
#include "Contact.h"
#include "Shedule.h"
#include "Order.h"
#include "Client.h"

class Librarian : public Human, public Contact, public Shedule
{
public:
	Librarian() {};
	~Librarian() {};
	void SetWorkExperience(int age);
	void SetJobTitle(std::string jobTitle);
	void SetShedule(Shedule* shedule);
	std::string GetJobTitle();
	void AddOrderInList(int orderNum, Client* client);
	void SaleOrder(int orderNum);
	void AddPromo(std::string promo);
	std::vector<Order> GetOrderlist();
	std::string GetWorktime();
	std::string GetPromo();
private:
	std::string promo = "NOT PROMO";
	int workExperience;
	std::string jobTitle;
	Shedule shedule;
	Client client;
	std::vector<Order> orderlist;
};