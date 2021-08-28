#include<iostream>
#include<algorithm>

using namespace std;

// 그리디 알고리즘

// 내림차순 정렬
bool desc(int a, int b) {
	return a > b;
}

int main() {
	int n, m, k;
	int a[1000] = {};
	cin >> n >> m >> k;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	// 배열 a 내림차순으로 정렬
	sort(a, a + n, desc);

	int first = a[0]; // 가장 큰 수
	int second = a[1]; // 두 번째로 큰 수
	int sum = 0; 
	int k2 = k; // 연속횟수를 세기 위한 변수


	for (int i = 0; i < m; i++) {
		
		if (k2 == 0) { // k2가 0과 같아지면 second 더하고 k2 초기화
			sum += second;
			cout << second << " ";
			k2 = k;
		}
		else { // first 한 번 더할 때마다 연속 가능한 수(k2) 1 감소
			sum += first;
			cout << first << " ";
			k2--;
		}
	}

	cout << sum;
}
