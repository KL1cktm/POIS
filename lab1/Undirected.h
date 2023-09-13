#pragma once
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

class UndirectedSet
{
private:
	vector<string> set;
	void CheckElement(string str);
	string FindSubset(string str, int* position);
	int SizeStr(string str);
	void AddInBoolSet(vector<vector<string>>& boolSet, vector<string>& subset);
	void CheckSubsets(vector<string>& subset);
	void CreateBooleanset(vector<vector<string>>& boolSet, vector<string> subset, int startPosition);
	void ShowBooleanSet();
	void EmptyBooleanSet(UndirectedSet booleanSubset, vector<vector<string>>& boolset);
public:
	vector<string> WriteSet(string str);
	void ShowSet();
	bool EmptySet();
	vector<string> AddElement(string str);
	vector<string> DeleteElement(string str);
	vector<string> DeleteElements(string str);
	int SetPower();
	bool SubsetBelongs(string str);
	vector<string> CombiningSets(UndirectedSet set2);
	vector<string> Intersections(UndirectedSet set2);
	vector<string> Difference(UndirectedSet set2);
	vector<vector<string>> BooleanSet();
};
