#include<iostream>
#include<vector>
#include<algorithm>


using namespace std;
vector<int> v;


// 그리디 알고리즘
// 백준 11047 : 동전 0

int main() {
    int n, k;
    int sum = 0;
    cin >> n >> k;

    // vector 사용 -> 공백 기준으로 삽입
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    // 가장 큰 수부터
    for (int i = n-1; i >= 0; i--) {
        if (k / v[i] != 0) {
            sum += k / v[i];
            k = k % v[i];
        } 
    }
    cout << sum;
    
}
