#define _USE_MATH_DEFINES
#include<iostream>
#include<iomanip>
#include<math.h>
using namespace std;


// 유클리드 기하학에서의 원의 넓이
double Euclid(int r) {
	double area = r * r * M_PI;
	return area;
}

// 택시 기하학에서의 원의 넓이
double Taxi(int r) {
	double area = r * r * 2;
	return area;
}

int main() {
	int r; // 반지름

	cin >> r;
	cout << fixed;
	cout.precision(6); // 소수점 6자리 고정
	cout << Euclid(r) << endl;
	cout << Taxi(r);
}


