#include<iostream>
#include<algorithm>

using namespace std;

// 그리디 알고리즘
// 백준 2839 : 설탕배달

int main() {
	int n;
	int i2 = 0; int j2 = 0;
	int sum = 0;

	cin >> n;

	// 5kg와 3kg로 나눌 수 있는 경우
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int k = (5 * i) + (3 * j);
			if (n == k) {
				i2 = i;
				j2 = j;
				sum = i2 + j2;
			}
		}
	}

	// 나눌 수 없는 경우
	if (i2 == 0 && j2 == 0) {
		sum = -1;
	}
	
	cout << sum;

}
