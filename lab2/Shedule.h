#pragma once
#include <iostream>
#include <string>

class Shedule
{
public:
	Shedule() {};
	~Shedule() {};
	void GetShedule();
	std::string GetWorktime();
	void SetWorktime(std::string worktime);
	void SetWorkweek(std::string workweek);
private:
	std::string worktime;
	std::string workweek;
};
