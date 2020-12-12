#include <iostream>
#include <vector>
using namespace std;

void func(vector<int>& a){
    a[0] = 0;
}

void func(int a[]){
    a[0] = 0;
}


int main(){

    int vect[1] = {1};

    cout << vect[0] << endl;

    func(vect);

    cout << vect[0] << endl;    

    return 0;
}