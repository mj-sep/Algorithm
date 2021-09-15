#include<iostream>
#include<stack>
#include<string>
#include<vector>
using namespace std;

vector<string> v;
string openclose[51];
string c;

string stack_confirm(string arr[], string num) {
	stack<string> s;
	for (int i = 0; i < num.size(); i++) {
		// 여는 괄호일 때
		if (arr[i] == "(") s.push(arr[i]);
		// 닫는 괄호일 때
		else if (arr[i] == ")") {
			if (!s.empty()) s.pop();
			else {
				return "NO";
			}
		}
	}
	
	if (s.empty()) {
		return "YES";
	}
	else return "NO";
	
}

int main() {
	
	int t;
	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> c;
		// 문자 하나씩 끊어서 배열에 입력
		for (int j = 0; j < c.size(); j++) {
			openclose[j] = c.substr(j, 1);
		}
		// 입력이 끝나고 한번에 출력해야 하므로 결과를 벡터에 저장해놓음.
		string str = stack_confirm(openclose, c);
		v.push_back(str);

	}
	
	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << "\n";
	}
	return 0;
}
