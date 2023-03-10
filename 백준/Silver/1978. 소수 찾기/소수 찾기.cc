#include<iostream>
#include<math.h>
using namespace std;

bool right(int num, int n);

int main() {
	int n; // n은 수의 개수
	int num;
	int count = 0;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> num;
		if (right(num, n)) {
			count += 1;
		}
	}
	cout << count;

	return 0;
}

bool right(int num, int n) {
	if (num <= 1)
		return false;

	for (int i = 2; i <= sqrt(num); i++) {
		if (num % i == 0) {
			return false;
		}
		else
			continue;
	return true;
	}
	
}