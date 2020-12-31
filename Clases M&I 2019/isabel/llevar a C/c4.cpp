#include <iostream>
#include<string.h>
using namespace std;
main(){
    char horaP[6],horaLL[6];
    char * hp, * mp, * hl, * ml;

    cout << "hora de partida : ";
    cin >>horaP;
    cout << "hora de llegada : ";
    cin >> horaLL;

    hp = strtok(horaP, ":");
    mp = strtok (NULL, ":");
    hl = strtok(horaLL, ":");
    ml = strtok (NULL, ":");

    int hrP = (hp[0]-48)*10 + (hp[1]-48);
    int minP = (mp[0]-48)*10 + (mp[1]-48);
    int hrL = (hl[0]-48)*10 + (hl[1]-48);
    int minL = (ml[0]-48)*10 + (ml[1]-48);

    cout << (hrL-hrP)<<":"<<(minL-minP);
}

