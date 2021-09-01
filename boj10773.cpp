#include<iostream>
#include<vector>
using namespace std;
vector<int> v;

// 백준 10773 : 제로

int main() {
	int k;
	cin >> k;
	for (int i = 0; i < k; i++) {
		int x;
		cin >> x;

		// stack
		if (x == 0) { // 0이 입력되면 pop
			v.pop_back();
		}
		else // 0이 아닌 다른 수가 입력된다면 push
			v.push_back(x);
	}

	int sum = 0;
	for (int i = 0; i < v.size(); i++) {
		sum += v[i];
	}

	cout << sum;
}
