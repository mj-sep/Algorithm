#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
vector<int> v;

// 그리디 알고리즘
// 백준 11399 : ATM

int main() {
	int n; // 사람수 
	int sum = 0;
	int sum2 = 0;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int x;
		cin >> x; // 걸리는 시간
		v.push_back(x); // 공백 기준으로 배열 생성
	}
	
	sort(v.begin(), v.end()); // 정렬 (오름차순)

	for (int i = 0; i < n; i++) {
		sum += v[i];
		sum2 += sum;
	}

	cout << sum2;

}
