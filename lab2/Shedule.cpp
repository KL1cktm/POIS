#include "Shedule.h"

void Shedule::GetShedule()
{
	std::cout << workweek << "   " << worktime << std::endl;
}

std::string Shedule::GetWorktime()
{
	return worktime;
}

void Shedule::SetWorktime(std::string worktime)
{
	this->worktime = worktime;
}

void Shedule::SetWorkweek(std::string workweek)
{
	this->workweek = workweek;
}
