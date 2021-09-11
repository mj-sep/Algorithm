#include<iostream>
#include<vector>
using namespace std;

vector<int> v;
vector<int> v2;
int n, n2, n3;

// quick sort (vector -> call by value X, call by reference O)
void quick_sort(vector<int> &arr,int start, int end){
    // 원소가 1개면 리턴
    if (start >= end) return;
    int pivot = start;
    int left = start + 1;
    int right = end;
    
    while (left <= right) {
        // 왼쪽부터 pivot보다 큰 수 찾기
        while (left <= end && arr[left] <= arr[pivot]) left++;
        // 오른쪽부터 pivot보다 작은 수 찾기
        while (right > start && arr[right] >= arr[pivot]) right--;
        // left와 right이 서로 엇갈리면 pivot과 작은 수 교환
        if (left > right) swap(arr[pivot], arr[right]);
        // 그렇지 않으면 left와 right 교환
        else swap(arr[left], arr[right]);
    }
    quick_sort(arr, start, right - 1);
    quick_sort(arr, right + 1, end);
}

int main() {
    int sum = 0;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> n2;
        v.push_back(n2);
    }

    for (int j = 0; j < n; j++) {
        cin >> n3;
        v2.push_back(n3);
    }

    quick_sort(v, 0, n - 1);
    quick_sort(v2, 0, n - 1);
    //sort(v2.begin(), v2.end(), greater<int>()); // 역순

   
    for (int i = 0; i < v.size(); i++) {
        sum += v[i] * v2[n - 1 - i];
    }
    cout << sum;

}
