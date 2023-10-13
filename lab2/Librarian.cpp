#include "Librarian.h"

void Librarian::SetWorkExperience(int age)
{
	this->workExperience = age;
}

void Librarian::SetJobTitle(std::string jobTitle)
{
	this->jobTitle = jobTitle;
}

void Librarian::SetShedule(Shedule* shedule)
{
	this->shedule = *shedule;
}

std::string Librarian::GetJobTitle()
{
	return jobTitle;
}

void Librarian::AddOrderInList(int orderNum, Client* client)
{
	if ((*client).GetStatus())
	{
		Order order = order.AddOrder(orderNum, client);
		orderlist.push_back(order);
	}
}

void Librarian::SaleOrder(int orderNum)
{
	for (int i = 0; i < orderlist.size(); i++)
	{
		if (orderlist[i].GetOrderNum() == orderNum)
		{
			Client* client = orderlist[i].GetClient();
			double price;
			if (client->GetPromo() == promo && promo != "NOT PROMO")
			{
				price = orderlist[i].GetPriceOrder() * 0.9;
			}
			else
			{
				price = orderlist[i].GetPriceOrder();
			}
			if ((*client).GetMoney() > price)
			{
				(*client).SetMoney((*client).GetMoney() - price);
				orderlist.erase(orderlist.begin() + i);
				return;
			}
		}
	}
}

void Librarian::AddPromo(std::string promo)
{
	this->promo = promo;
}

std::vector<Order> Librarian::GetOrderlist()
{
	return orderlist;
}

std::string Librarian::GetWorktime()
{
	return shedule.GetWorktime();
}

std::string Librarian::GetPromo()
{
	return promo;
}
