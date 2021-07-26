#include<iostream>
using namespace std;


void insert_sort(int num[], int k) { // 삽입정렬
	int i, j, key;

	for (i = 1; i < k; i++) {
		key = num[i]; 
		
		// 현재 배열은 i-1까지 정렬되어 있음
		// i-1부터 역순으로 조사, j는 음수가 아니어야 하며 key보다 j 값이 클 시
		// j 번째를 j+1 번째로 이동
		for (j = i - 1; j >= 0 && num[j] > key; j--) {
			num[j + 1] = num[j]; 
		}

		// j+1 번째에 key 값 할당
		num[j + 1] = key;
	}
}

int main() {

	int k; 
	int num[1000];

	cin >> k ; // 수의 개수
	for (int i = 0; i < k; i++) {
		cin >> num[i];
	}


	insert_sort(num, k);
	for (int i = 0; i < k; i++) {
		cout << num[i] << "\n";
	}
}

