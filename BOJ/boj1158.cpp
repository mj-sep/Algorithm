// BOJ 1158 : 요세푸스 문제
#include<iostream>
#include<queue>
using namespace std;

queue<int> q;

int main() {
	int n, k, top, pop;
	cin >> n >> k;

	// 큐에 순서대로 삽입
	for (int i = 1; i <= n; i++) {
		q.push(i);
	}

	cout << "<";
	// 순서대로 k번째 사람 제거
	while (!q.empty()) {
		for (int i = 0; i < k-1; i++) {
			top = q.front();
			q.pop();
			q.push(top);
		}
		pop = q.front();
		q.pop();
		if (q.empty()) cout << pop;
		else cout << pop << ", ";
		}
	cout << ">";

}
