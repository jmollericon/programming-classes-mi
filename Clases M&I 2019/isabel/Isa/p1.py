print("Ingrese una palabra")
cad = input()

# upper   a.upper()
# lower

n = len(cad)
for i in range(n):
    car = cad[i]
    cadFin = " " 
    if(car=='a' or car=='e' or car=='i' or car=='o' or car=='u' or car=='A' or car=='E' or car=='I' or car=='O' or car=='U'):
        cadFin = cadFin + car #.upper()
#        print(car)
    else:
        cadFin = cadFin + car #.lower()
#        print(car)

print(cadFin)
#print(f"Me alegro de conocerle, {cadFin}")