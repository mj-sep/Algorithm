#define _USE_MATH_DEFINES
#include<iostream>
#include<iomanip>
#include<math.h>
using namespace std;


// ��Ŭ���� �����п����� ���� ����
double Euclid(int r) {
	double area = r * r * M_PI;
	return area;
}

// �ý� �����п����� ���� ����
double Taxi(int r) {
	double area = r * r * 2;
	return area;
}

int main() {
	int r; // ������

	cin >> r;
	cout << fixed;
	cout.precision(6); // �Ҽ��� 6�ڸ� ����
	cout << Euclid(r) << endl;
	cout << Taxi(r);
}


