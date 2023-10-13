#pragma once
#include <iostream>
#include <vector>
#include "Client.h"

class Order
{
public:
	Order();
	~Order() {};
	Order AddOrder(int orderNum, Client* client);
	int GetOrderNum();
	Client* GetClient();
	double GetPriceOrder();
private:
	int orderNum;
	Client* client;
	std::vector<Book> books;
	double price;
};