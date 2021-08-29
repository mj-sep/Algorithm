#include<iostream>
#include<algorithm>

using namespace std;

// 그리디 알고리즘
// 이것이 취업을 위한 코딩 테스트다 with 파이썬 (p.99)

int main() {
	int n, k;
	int sum = 0;
	
	cin >> n >> k;

	// n이 1이 될 때까지 반복
	while (n != 1) {
		if (n % k == 0) { // 2번 조건이 충족된다면 2번부터 실행
			n = n / k;
			sum++;
		}
		else { // 2번 조건이 충족되지 않는다면 1번 실행
			n = n - 1;
			sum++;
		}
	}

	cout << sum;
	
}
