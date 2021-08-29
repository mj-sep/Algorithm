#include<iostream>
#include<algorithm>

using namespace std;

// 그리디 알고리즘
// 백준 5585 : 거스름돈

int main() {
	int n;
	int sum = 0;
	
	cin >> n;

	// 거스름돈 계산
	int money = 1000 - n;

	// 잔돈 배열
	int change[6] = { 500, 100, 50, 10, 5, 1 };


	// 500엔부터 순차적으로 계산
	for (int i = 0; i < 6; i++) {
		if (money / change[i] != 0) {
			sum = sum + (money / change[i]);
			money = money % change[i];
		}

	}

	cout << sum;
	
}
