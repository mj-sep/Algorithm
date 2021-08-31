#include<iostream>
using namespace std;

// 구현
// 이것이 취업을 위한 코딩 테스트다 with 파이썬 (p.113)


// 시간에 3이 들어가면 true 리턴
bool check(int i, int j, int k) {
    if (i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3 || k % 10 == 3) {
        return true;
    }
    return false;
}

int main() {
    int n;
    cin >> n;
    int sum = 0;
    
    for (int i = 0; i <= n; i++) { // 시
        for (int j = 0; j <= 59; j++) { // 분
            for (int k = 0; k <= 59; k++) { // 초
                if (check(i, j, k))
                    sum++;
            }
        }
    }
  
    cout << sum;
}
