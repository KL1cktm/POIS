#include "Undirected.h"

void UndirectedSet::CheckElementForEmpties(string str)
{
	if (str != "{}" && str != " " && str != "")
	{
		set.push_back(str);
	}
	else
	{
		set.push_back("{}");
	}
}

string UndirectedSet::FindSubset(string str, int* position)
{
	int bracketCounter = 0;
	string subset = "";
	for (int i = *position; i < size(str); i++)
	{
		if (str[i] == '{')
		{
			bracketCounter++;
		}
		if (str[i] == '}' && bracketCounter == 1)
		{
			subset = str.substr(*position, i - *position + 1);
			*position = i;
			return subset;
		}
		if (str[i] == '}' && bracketCounter != 1)
		{
			bracketCounter--;
		}
	}
}

int UndirectedSet::SizeStr(string str)
{
	int size;
	for (int size = 0; size < 100; size++)
	{
		if (str[size] == '\0')
		{
			return size + 1;
		}
	}
}

void UndirectedSet::AddInBoolSet(vector<vector<string>>& boolSet, vector<string>& subset)
{
	bool count = true;
	for (int i = 0; i < size(boolSet); i++)
	{
		if (boolSet[i] == subset)
		{
			count = false;
		}
	}
	if (count)
	{
		boolSet.push_back(subset);
	}
}

void UndirectedSet::CheckSubsets(vector<string>& subset)
{
	sort(subset.begin(), subset.end());
	vector<string> bufferSet = set;
	for (int i = 0; i < size(subset); i++)
	{
		for (int j = 0; j < size(bufferSet); j++)
		{
			if (bufferSet[j] == subset[i])
			{
				bufferSet.erase(bufferSet.begin() + j);
				break;
			}
			if (bufferSet[j] != subset[i] && j == size(bufferSet) - 1)
			{
				subset.erase(subset.begin() + i);
			}
		}
	}
}

void UndirectedSet::CreateBooleanset(vector<vector<string>>& boolSet, vector<string> subset, int startPosition)
{
	for (int i = startPosition; i < size(set); i++) {
		subset.push_back(set[i]);
		CreateBooleanset(boolSet, subset, startPosition + 1);
		for (int j = i + 1; j < size(set); j++) {
			subset.push_back(set[j]);
			if (j + 1 < size(set))
			{
				CreateBooleanset(boolSet, subset, j + 1);
			}
			CheckSubsets(subset);
			AddInBoolSet(boolSet, subset);
			subset.pop_back();
		}
		CheckSubsets(subset);
		AddInBoolSet(boolSet, subset);
		subset.pop_back();
	}
	sort(boolSet.begin(), boolSet.end());
}

void UndirectedSet::ShowBooleanSet()
{
	cout << "{";
	for (int i = 0; i < size(set); i++) {
		if (i + 1 != size(set))
		{
			cout << set[i] << ",";
		}
		else
		{
			cout << set[i];
		}
	}
	cout << "}";
}

void UndirectedSet::EmptyBooleanSet(UndirectedSet booleanSubset,vector<vector<string>>& boolSet)
{
	int counter = 0;
	for (int i = 0; i < size(booleanSubset.set); i++)
	{
		if (booleanSubset.set[i] == "{}")
		{
			counter = 1;
		}
	}
	if (counter == 0)
	{
		booleanSubset.set.push_back("{}");
		vector<string> emptyElement;
		emptyElement.push_back("{}");
		boolSet.push_back(emptyElement);
		cout << ",{}";
	}
}

vector<string> UndirectedSet::WriteSet(string str)
{
	set.clear();
	string element;
	for (int i = 0; i < SizeStr(str); i++)
	{
		if (str[i] == ',' || str[i] == '\0') {
			CheckElementForEmpties(element);
			element.clear();
		}
		if (str[i] == '{') {
			element = FindSubset(str, &i);
		}
		if (str[i] != '{' && str[i] != ',' && str[i] != '}') {
			element += str[i];
		}
	}
	return set;
}

void UndirectedSet::ShowSet()
{
	cout << "{";
	for (int i = 0; i < size(set); i++) {
		if (i + 1 != size(set))
		{
			cout << set[i] << ",";
		}
		else
		{
			cout << set[i];
		}
	}
	cout << "}" << endl;
}

bool UndirectedSet::EmptySet()
{
	if (size(set) == 1 && set[0] == "{}")
	{
		cout << "An empty set was found" << endl;
		return true;
	}
	else
	{
		cout << "The set is not empty" << endl;
		return false;
	}
}

vector<string> UndirectedSet::AddElement(string str)
{
	set.push_back(str);
	return set;
}

vector<string> UndirectedSet::DeleteElement(string str)
{
	for (int i = 0; i < size(set); i++)
	{
		if (set[i] == str)
		{
			set.erase(set.begin() + i);
			break;
		}
	}
	return set;
}

vector<string> UndirectedSet::DeleteElements(string str)
{
	for (int i = 0; i < size(set); i++)
	{
		if (set[i] == str)
		{
			set.erase(set.begin() + i);
		}
	}
	return set;
}

int UndirectedSet::SetPower()
{
	vector<string> power;
	if (size(set) == 0)
	{
		cout << "Power of the set: 0" << endl;
		return size(set);
	}
	else
	{
		power.push_back(set[0]);
		for (int i = 0; i < size(set); i++)
		{
			int count = 0;
			for (int j = 0; j < size(power); j++)
			{
				if (power[j] == set[i])
				{
					count = 1;
				}
			}
			if (count == 0)
			{
				power.push_back(set[i]);
			}
		}
		cout << "Power of the set: " << size(power) << endl;
		return size(power);
	}
}

bool UndirectedSet::SubsetBelongs(string str)
{
	for (int i = 0; i < size(set); i++)
	{
		if (set[i] == str)
		{
			return true;
		}
	}
	return false;
}

vector<string> UndirectedSet::CombiningSets(UndirectedSet set2)
{
	UndirectedSet combining;
	combining.set = set;
	for (int i = 0; i < size(set2.set); i++)
	{
		combining.set.push_back(set2.set[i]);
	}
	combining.ShowSet();
	return combining.set;
}

vector<string> UndirectedSet::Intersections(UndirectedSet set2)
{
	UndirectedSet intersection;
	for (int i = 0; i < size(set); i++)
	{
		for (int j = 0; j < size(set2.set); j++)
		{
			if (set2.set[j] == set[i])
			{
				set2.set.erase(set2.set.begin() + j);
				j = size(set2.set);
				intersection.AddElement(set[i]);
			}
		}
	}
	intersection.ShowSet();
	return intersection.set;
}

vector<string> UndirectedSet::Difference(UndirectedSet set2)
{
	UndirectedSet difference;
	difference.set = set;
	for (int i = 0; i < size(set2.set); i++)
	{
		for (int j = 0; j < size(difference.set); j++)
		{
			if (difference.set[j] == set2.set[i])
			{
				difference.set.erase(difference.set.begin() + j);
			}
		}
	}
	difference.ShowSet();
	return difference.set;
}

vector<vector<string>> UndirectedSet::BooleanSet()
{
	vector<vector<string>> boolSet;
	vector<string> subset;
	int startposition = 0;
	CreateBooleanset(boolSet, subset, startposition);
	UndirectedSet boolSubset;
	cout << "Boolean set: {";
	int commacounter = 0;
	for (int i = 0; i < size(boolSet); i++)
	{
		boolSubset.set = boolSet[i];
		boolSubset.ShowBooleanSet();
		if (commacounter < pow(2, size(set)) - 2)
		{
			cout << ",";
			commacounter++;
		}
	}
	EmptyBooleanSet(boolSubset,boolSet);
	cout << "}" << endl;
	return boolSet;
}

