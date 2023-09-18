#include "pch.h"
#include "CppUnitTest.h"
#include "../UndirectedSet/Undirected.h"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace UnitTest1
{
	TEST_CLASS(UnitTest1)
	{
	public:
		
		TEST_METHOD(TestMethod1)
		{
			UndirectedSet set;
			vector<string> st1;
			st1.push_back("a");
			st1.push_back("b");
			st1.push_back("c");
			string str = "a,b,c";
			Assert::IsTrue(st1 == set.WriteSet(str));
		}
		TEST_METHOD(TestMethod2)
		{
			UndirectedSet set;
			vector<string> st1;
			st1.push_back("a");
			st1.push_back("{b,c}");
			string str = "a,{b,c}";
			Assert::IsTrue(st1 == set.WriteSet(str));
		}
		TEST_METHOD(TestMethod3)
		{
			UndirectedSet set;
			string str = "{}";
			set.WriteSet(str);
			Assert::IsTrue(set.EmptySet());
		}
		TEST_METHOD(TestMethod4)
		{
			UndirectedSet set;
			string str = "{a}";
			set.WriteSet(str);
			Assert::IsTrue(!set.EmptySet());
		}
		TEST_METHOD(TestMethod5)
		{
			UndirectedSet set;
			vector<string> st1;
			st1.push_back("a");
			st1.push_back("b");
			st1.push_back("c");
			st1.push_back("rr");
			string str = "a,b,c";
			set.WriteSet(str);
			Assert::IsTrue(st1 == set.AddElement("rr"));
		}
		TEST_METHOD(TestMethod6)
		{
			UndirectedSet set;
			vector<string> st1;
			st1.push_back("a");
			st1.push_back("c");
			string str = "a,b,c";
			set.WriteSet(str);
			Assert::IsTrue(st1 == set.DeleteElement("b"));
		}
		TEST_METHOD(TestMethod7)
		{
			UndirectedSet set;
			string str = "a,b,c,d,{fs,r},t";
			set.WriteSet(str);
			Assert::IsTrue(6 == set.SetPower());
		}
		TEST_METHOD(TestMethod8)
		{
			UndirectedSet set;
			string str = "a,b,c,a,b,b,a,r";
			set.WriteSet(str);
			Assert::IsTrue(4 == set.SetPower());
		}
		TEST_METHOD(TestMethod9)
		{
			UndirectedSet set;
			string str = "a,b,c,a,b,b,a,r";
			set.WriteSet(str);
			Assert::IsTrue(!set.SubsetBelongs("t"));
		}
		TEST_METHOD(TestMethod10)
		{
			UndirectedSet set;
			string str = "a,b,c,d,e,{f,g}";
			set.WriteSet(str);
			Assert::IsTrue(set.SubsetBelongs("{f,g}"));
		}
		TEST_METHOD(TestMethod11)
		{
			UndirectedSet set1;
			UndirectedSet set2;
			string str = "a,b,c";
			set1.WriteSet(str);
			str = "c,d,e";
			set2.WriteSet(str);
			vector<string> st;
			st.push_back("a");
			st.push_back("b");
			st.push_back("c");
			st.push_back("c");
			st.push_back("d");
			st.push_back("e");
			Assert::IsTrue(st == set1.CombiningSets(set2));
		}
		TEST_METHOD(TestMethod12)
		{
			UndirectedSet set1;
			UndirectedSet set2;
			string str = "a,b,c,d,e,f";
			set1.WriteSet(str);
			str = "d,e,f,g,h,i";
			set2.WriteSet(str);
			vector<string> st;
			st.push_back("d");
			st.push_back("e");
			st.push_back("f");
			Assert::IsTrue(st == set1.Intersections(set2));
		}
		TEST_METHOD(TestMethod13)
		{
			UndirectedSet set1;
			UndirectedSet set2;
			string str = "c,a,b,d,e,f,g,c";
			set1.WriteSet(str);
			str = "c,e,f,g,h,c";
			set2.WriteSet(str);
			vector<string> st;
			st.push_back("c");
			st.push_back("e");
			st.push_back("f");
			st.push_back("g");
			st.push_back("c");
			Assert::IsTrue(st == set1.Intersections(set2));
		}
		TEST_METHOD(TestMethod14)
		{
			UndirectedSet set1;
			UndirectedSet set2;
			string str = "a,b,c,d,e,f,g,h";
			set1.WriteSet(str);
			str = "c,r,t,b,h,e,d";
			set2.WriteSet(str);
			vector<string> st;
			st.push_back("a");
			st.push_back("f");
			st.push_back("g");
			Assert::IsTrue(st == set1.Difference(set2));
		}
		TEST_METHOD(TestMethod15)
		{
			UndirectedSet set1;
			vector<string> st;
			vector<vector<string>> vvs;
			string str = "a,b,c";
			st.push_back("a");
			vvs.push_back(st);
			st.clear();
			st.push_back("a");
			st.push_back("b");
			vvs.push_back(st);
			st.clear();
			st.push_back("a");
			st.push_back("b");
			st.push_back("c");
			vvs.push_back(st);
			st.clear();
			st.push_back("a");
			st.push_back("c");
			vvs.push_back(st);
			st.clear();
			st.push_back("b");
			vvs.push_back(st);
			st.clear();
			st.push_back("b");
			st.push_back("c");
			vvs.push_back(st);
			st.clear();
			st.push_back("c");
			vvs.push_back(st);
			st.clear();
			st.push_back("{}");
			vvs.push_back(st);
			set1.WriteSet(str);
			Assert::IsTrue(vvs == set1.BooleanSet());
		}
		TEST_METHOD(TestMethod16)
		{
			UndirectedSet set1;
			vector<string> st;
			vector<vector<string>> vvs;
			string str = "a,b";
			st.push_back("a");
			vvs.push_back(st);
			st.clear();
			st.push_back("a");
			st.push_back("b");
			vvs.push_back(st);
			st.clear();
			st.push_back("b");
			vvs.push_back(st);
			st.clear();
			st.push_back("{}");
			vvs.push_back(st);
			set1.WriteSet(str);
			Assert::IsTrue(vvs == set1.BooleanSet());
		}
		TEST_METHOD(TestMethod17)
		{
			UndirectedSet set1;
			char arr[] = { 'a',',','v',',','c','\0'};
			vector<string> st;
			st.push_back("a");
			st.push_back("v");
			st.push_back("c");
			Assert::IsTrue(st == set1.WriteSet(arr));
		}
		TEST_METHOD(TestMethod18)
		{
			UndirectedSet set1;
			char arr[] = { 'a',',','{','d',',','f','}',',','r','\0'};
			vector<string> st;
			st.push_back("a");
			st.push_back("{d,f}");
			st.push_back("r");
			Assert::IsTrue(st == set1.WriteSet(arr));
		}
		TEST_METHOD(TestMethod19)
		{
			UndirectedSet set;
			vector<string> st1;
			st1.push_back("a");
			st1.push_back("c");
			st1.push_back("e");
			string str = "a,b,c,b,e";
			set.WriteSet(str);
			Assert::IsTrue(st1 == set.DeleteElements("b"));
		}

		TEST_METHOD(TestMethod20)
		{
			UndirectedSet set;
			Assert::IsTrue(0 == set.SetPower());
		}
	};
}
