#include "pch.h"
#include "CppUnitTest.h"
#include "../Warehouse/HeaderPicker.h"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace BookWarehouseTest
{
	TEST_CLASS(BookWarehouseTest)
	{
	public:

		TEST_METHOD(TestMethod1)
		{
			Book book;
			book.SetPrice(7.8);
			book.SetTitle("Harry Poter");
			book.SetAuthor("Joanne", "Rowling", "British author, creator of the popular and critically acclaimed Harry Potter series, about a young sorcerer in training.");
			book.SetPublishinghouse("J.K.Rowling", "1997-2007");
			Assert::AreEqual(book.GetPrice(), 7.8);
		}
		TEST_METHOD(TestMethod2)
		{
			Book book;
			book.SetPrice(7.8);
			book.SetTitle("Harry Poter");
			book.SetAuthor("Joanne", "Rowling", "British author, creator of the popular and critically acclaimed Harry Potter series, about a young sorcerer in training.");
			book.SetPublishinghouse("J.K.Rowling", "1997-2007");
			Client client;
			client.SetMoney(78);
			client.SetStatus(true);
			client.AddBookInList(book);
			std::vector<Book> booka;
			booka.push_back(book);
			std::vector<Book> clientBooks = client.GetList();
			Assert::AreEqual(booka.size(), clientBooks.size());
			for (size_t i = 0; i < booka.size(); i++) {
				Assert::AreEqual(booka[i].GetTitle(), clientBooks[i].GetTitle());
			}
		}
		TEST_METHOD(TestMethod3)
		{
			Book book;
			book.SetPrice(8);
			book.SetTitle("Harry Poter");
			book.SetAuthor("Joanne", "Rowling", "British author, creator of the popular and critically acclaimed Harry Potter series, about a young sorcerer in training.");
			book.SetPublishinghouse("J.K.Rowling", "1997-2007");
			Client client;
			client.SetMoney(78);
			client.SetStatus(true);
			client.AddBookInList(book);
			client.WritePromo("PROMOs");
			Librarian librarian;
			librarian.SetAge(43);
			librarian.AddPromo("PROMO");
			librarian.AddOrderInList(1234, &client);
			librarian.SaleOrder(1234);
			Assert::AreEqual(client.GetMoney(), double(78-8));
		}
		TEST_METHOD(TestMethod4)
		{
			Book book;
			book.SetPrice(8);
			book.SetTitle("Harry Poter");
			book.SetAuthor("Joanne", "Rowling", "British author, creator of the popular and critically acclaimed Harry Potter series, about a young sorcerer in training.");
			book.SetPublishinghouse("J.K.Rowling", "1997-2007");
			Client client;
			client.SetMoney(78);
			client.SetStatus(true);
			client.AddBookInList(book);
			client.WritePromo("PROMO");
			Librarian librarian;
			librarian.SetEmail("urgzhenyok@mail.ru");
			librarian.SetAddress("Minsk");
			librarian.AddPromo("PROMO");
			librarian.AddOrderInList(1234, &client);
			librarian.SaleOrder(1234);
			Assert::AreEqual(client.GetMoney(), double(78 - 8*0.9));
		}
		TEST_METHOD(TestMethod5)
		{
			Book book;
			book.SetPrice(8);
			book.SetTitle("Harry Poter");
			book.SetAuthor("Joanne", "Rowling", "British author, creator of the popular and critically acclaimed Harry Potter series, about a young sorcerer in training.");
			book.SetPublishinghouse("J.K.Rowling", "1997-2007");
			Client client;
			client.WriteReview(&book, "Best book", 4.8);
			Assert::AreEqual(book.ViewReview(), 4.8);
		}
		TEST_METHOD(TestMethod6)
		{
			BookWarehouse house;
			Shedule* shedule;
			house.SetPhoneNumber("3754477777777");
			shedule = house.SetShedule("8:00-17:00", "monday-friday");
			Librarian libr;
			libr.SetShedule(shedule);
			std::string str = "8:00-17:00";
			Assert::AreEqual(libr.GetWorktime(), str);
		}
		TEST_METHOD(TestMethod7)
		{
			BookWarehouse house;
			Librarian libr1;
			libr1.SetJobTitle("1");
			Librarian libr2;
			libr2.SetJobTitle("2");
			Librarian libr3;
			libr3.SetJobTitle("3");
			house.AddLibrerian(libr1);
			house.AddLibrerian(libr2);
			house.AddLibrerian(libr3);
			std::vector<std::string> st;
			st.push_back("1");
			st.push_back("2");
			st.push_back("3");
			for (int i = 0; i < house.ViewStaff().size(); i++)
			{
				Assert::AreEqual(house.ViewStaff()[i].GetJobTitle(),st[i]);
			}
		}
		TEST_METHOD(TestMethod8)
		{
			Book book;
			book.SetPrice(8);
			Book book1;
			book1.SetPrice(12);
			Book book2;
			book2.SetPrice(13);
			Assert::AreEqual(book.GetPrice(), double(8));
			Client client;
			client.SetLastname("Yurhilevich");
			std::string str = "Yurhilevich";
			Assert::AreEqual(client.GetLastname(), str);
			Librarian libr;
			client.AddBookInList(book);
			client.SetStatus(true);
			client.AddBookInList(book1);
			client.AddBookInList(book2);
			libr.AddOrderInList(1234, &client);
			int size = libr.GetOrderlist().size();
			Assert::AreEqual(size, 1);
			Assert::AreEqual(libr.GetOrderlist()[0].GetPriceOrder(), double(33));
		}
	};
}
