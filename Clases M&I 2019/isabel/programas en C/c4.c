#include<stdio.h>
#include<string.h>
main(){
    char horaP[6],horaLL[6];
    char * hp, * mp, * hl, * ml;

    printf("hora de partida : ");
	scanf("%s",&horaP);
    printf("hora de llegada : ");
    scanf("%s",&horaLL);

    hp = strtok(horaP, ":");
    mp = strtok (NULL, ":");
    hl = strtok(horaLL, ":");
    ml = strtok (NULL, ":");

    int hrP = (hp[0]-48)*10 + (hp[1]-48);
    int minP = (mp[0]-48)*10 + (mp[1]-48);
    int hrL = (hl[0]-48)*10 + (hl[1]-48);
    int minL = (ml[0]-48)*10 + (ml[1]-48);

    printf("Se demoro -> %d:%d",(hrL-hrP),(minL-minP));
}
