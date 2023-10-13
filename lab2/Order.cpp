#include "Order.h"

Order::Order()
{
	this->price = 0;
}

Order Order::AddOrder(int orderNum, Client* client)
{
	Order* order = new Order;
	order->orderNum = orderNum;
	order->client = client;
	books = (*client).GetList();
	for (int i = 0; i < books.size(); i++)
	{
		order->price += books[i].GetPrice();
	}
	return *order;
}

int Order::GetOrderNum()
{
	return orderNum;
}

Client* Order::GetClient()
{
	return client;
}

double Order::GetPriceOrder()
{
	return price;
}
