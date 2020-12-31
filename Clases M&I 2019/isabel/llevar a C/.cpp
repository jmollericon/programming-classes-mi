#include<iostream>
using namespace std;
main (){
for(int t=1;t<10;t++){
    for(int b=1;b<=10-t;b++){
    cout<<b<<" ";}
    cout<<"\n";
    for(int c=10-t;c>=1;c--){
    cout<<c<<" ";
    }
    cout<<"\n";
}
}


