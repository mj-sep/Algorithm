#include<iostream>
#include<vector>
#include<string>
using namespace std;
vector<string> v;

// 백준 8958 : OX퀴즈

int main() {

	int n; // 테스트 케이스의 수
	cin >> n;

	int point = 0;
	int sum = 0;

	for (int i = 0; i < n; i++) {
		string x;
		cin >> x;
		v.push_back(x);
	}

	for (int i = 0; i < v.size(); i++) {
		for (int j = 0; j < v[i].length(); j++) {
			string word = v[i].substr(j, 1); // j부터 문자열 1개씩 
			if (word == "O") {
				point++;
				sum += point;
			}
			else {
				point = 0;
			}
		}
		cout << sum << endl;
		sum = 0;
		point = 0;
	}
}
