# MAMN01 - Individuell Inlämningsuppgift

### Kompass
Funktionaliteten för kompassen är tagen från länken given i moodle, med en annan bild. Efter att ha läst runt lite grann så fixade jag också så att mobilen vibrerar när man pekar mot norr, och att värdena från sensorn går igenom ett low-pass filter. Koden för filtret är också tagen från länk given i moodle, men funkar dock inte som den ska, kompassen gör fortfarande stora hopp mellan olika värden. Detta tror jag beror på att jag inte har filtrerat värderna för TYPE_ROTATION vektorn då det är en så kallad software sensor och inte hade en förklaring för filtrering. 

### Accelerometer
Funktionaliteten för accelerometern är fixad genom att välja ut relevant kod från kompass koden och helt enkelt lägga till några text fields som ändrar värde när du vrider på telefonen. Även här går dessa värden genom ett low-pass filter, men jag kan själv inte se att det hjälper speciellt mycket.
