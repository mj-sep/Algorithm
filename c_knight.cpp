#include<iostream>
#include<vector>
#include<string>
using namespace std;
vector<int> v;

// 구현
// 이것이 취업을 위한 코딩 테스트다 with 파이썬 (p.115)


int main() {
	
	// 경우의 수
	int x[8] = { -2, -2, 2, 2, -1, -1, 1, 1 };
	int y[8] = { 1, -1, 1, -1, 2, -2, 2, -2 };

	string knight;
	cin >> knight;

	int x_pos = knight[1] - '0';
	int y_pos = knight[0] - 'a' + 1; // 숫자로 변환
	
	int sum = 0;
	for (int i = 0; i < 8; i++) {
		int next_x = x_pos + x[i];
		int next_y = y_pos + y[i];

		// 이동이 가능하다면 sum 증가
		if (next_x <= 8 && next_x >= 1 && next_y <= 8 && next_y >= 1) {
			sum++;
		}
	}

	cout << sum;

}
