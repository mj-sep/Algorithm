#include<iostream>
#include<queue>
using namespace std;

queue<int> q;

// queue-push
void push(int x) {
	q.push(x);
}

// queue-push 제외
void f_queue(string x) {
	if (x == "pop") {
		if (q.empty()) cout << "-1\n";
		else {
			cout << q.front() << "\n";
			q.pop();
		}
	}
	else if (x == "size") {
		cout << q.size() << "\n";
	}
	else if (x == "empty") {
		if (q.empty()) cout << "1\n";
		else cout << "0\n";
	}
	else if (x == "front") {
		if (q.empty()) cout << "-1\n";
		else cout << q.front() << "\n";
	}
	else if (x == "back") {
		if (q.empty()) cout << "-1\n";
		else cout << q.back() << "\n";
	}

}

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		string quest;
		cin >> quest;

		if (quest == "push") {
			int n2;
			cin >> n2;
			push(n2);
		}
		else
			f_queue(quest);
	}
}
