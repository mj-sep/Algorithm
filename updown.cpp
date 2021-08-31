#include<iostream>
#include<string>
using namespace std;

// 구현
// 이것이 취업을 위한 코딩 테스트다 with 파이썬 (p.110)


int main() {
    int n;
    string x;
    cin >> n;

    int pos_x = 1; 
    int pos_y = 1;
    
    cin.ignore(); // 버퍼 비우기
    getline(cin, x);
    
    // 상하좌우 이동 실행 (칸 넘어가면 실행무효화)
    for (int i = 0; i < x.size(); i++) {
        char x_property = x[i];
        if (x_property == 'R') {
            if (pos_y < n) {
                pos_y += 1;
            }
        }
        else if (x_property == 'L') {
            if (pos_y > 1) {
                pos_y -= 1;
            }
        }
        else if (x_property == 'U') {
            if (pos_x > 1) {
                pos_x -= 1;
            }
        }
        else if(x_property == 'D'){
            if (pos_x < n) {
                pos_x += 1;
            }
        }

    }
    cout << pos_x << " " << pos_y;
  
}
