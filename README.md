# MAMN01 - Individuell Inlämningsuppgift

### Kompass
Funktionaliteten för kompassen är tagen från länken given i moodle, med en annan bild. Efter att ha läst runt lite grann så fixade jag också så att mobilen vibrerar när man pekar mot norr, och att värdena från sensorn går igenom ett low-pass filter. Koden för filtret är också tagen från länk given i moodle, men funkar dock inte som den ska, kompassen gör fortfarande stora hopp mellan olika värden. Detta tror jag beror på att jag inte har filtrerat värderna för TYPE_ROTATION vektorn då det är en så kallad software sensor och inte hade en förklaring för filtrering. 

Utöver low-pass filter och att telefonen vibrerar vid en viss vinkel som tillägg så har jag också lagt till ett sätt för användaren att bestämma vilken vinkel som telefonen ska vibrera på. Skriver användaren in ett värde som är över 360 grader så tar appen modulo på detta värde och vibrerar på resten. Värdet som den kommer vibrera på kommer upp i en så kallad Toast efter det är satt.

### Accelerometer
Funktionaliteten för accelerometern är fixad genom att välja ut relevant kod från kompass koden och helt enkelt lägga till några text fields som ändrar värde när du vrider på telefonen. Även här går dessa värden genom ett low-pass filter, men jag kan själv inte se att det hjälper speciellt mycket.

Utöver low-pass filter som tillägg så har jag också lagt till texten som visar om man lutar telefonen åt vänster eller höger, det använder ingen kopierad kod utan jag kollade värdena när man lutade på telefonen och utgick därifrån.
