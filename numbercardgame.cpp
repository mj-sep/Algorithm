#include<iostream>
#include<algorithm>

using namespace std;

// 그리디 알고리즘
// 이것이 취업을 위한 코딩 테스트다 with 파이썬 (p.96)

int main() {
	int n, m;
	int card[100][100] = {};

	cin >> n >> m;

	// 입력 받기 (배열)
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> card[i][j];
		}
	}

	// 행마다 작은 숫자 찾기
	int min[100] = {};
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			min[j] = card[i][0];
			if (card[i][j] < min[i])
				min[i] = card[i][j];
		}
	}

	// 각 행의 작은 숫자 중 큰 수 찾기
	int select = min[0];
	for (int i = 0; i < n; i++) {
		if (select > min[i])
			select = min[i];
	}

	cout << select;
}
