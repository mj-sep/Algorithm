#include<iostream>
using namespace std;


void insert_sort(int num[], int k) { // ��������
	int i, j, key;

	for (i = 1; i < k; i++) {
		key = num[i]; 
		
		// ���� �迭�� i-1���� ���ĵǾ� ����
		// i-1���� �������� ����, j�� ������ �ƴϾ�� �ϸ� key���� j ���� Ŭ ��
		// j ��°�� j+1 ��°�� �̵�
		for (j = i - 1; j >= 0 && num[j] > key; j--) {
			num[j + 1] = num[j]; 
		}

		// j+1 ��°�� key �� �Ҵ�
		num[j + 1] = key;
	}
}

int main() {

	int k; 
	int num[1000];

	cin >> k ; // ���� ����
	for (int i = 0; i < k; i++) {
		cin >> num[i];
	}


	insert_sort(num, k);
	for (int i = 0; i < k; i++) {
		cout << num[i] << "\n";
	}
}

