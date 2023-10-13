#include "Author.h"

void Author::SetBiography(std::string biography)
{
	this->biography = biography;
}

void Author::GetBiography()
{
	std::cout << biography << std::endl;
}
