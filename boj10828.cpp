#include<iostream>
#include<stack>
using namespace std;

stack<int> s;

// push
void push(int x) {
    s.push(x);
}

// push 제외한 명령어
void f_stack(string x) {
    if (x == "top") {
        if (s.empty()) cout << "-1\n";
        else cout << s.top() << "\n";
    }
    else if (x == "pop") {
        if (s.empty()) cout << "-1\n";
        else {
            cout << s.top();
            s.pop();
            cout << "\n";
        }
    }
    else if (x == "empty") {
        if (s.empty()) cout << "1\n";
        else cout << "0\n";
    }
    else if (x == "size") {
        cout << s.size() << "\n";
    }
}


int main() {
    int n;
    cin >> n; // 주어지는 명령의 수

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        
        if (s == "push") {
            int n;
            cin >> n;
            push(n);
        }
        else {
            f_stack(s);
        }
             
    }
}
