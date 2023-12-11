# Ecredit-FrontEnd

http://localhost:9092/api/SituationFamiliale/add
{
  "situation":"Marié(e)"
}

http://localhost:9092/api/Unite/add
{
  "nom":"TND"
}
http://localhost:9092/api/Devise/add
{
  "nom":"TND "
}

http://localhost:9092/api/Customer
{ 
  "cin":14655144,
  "lastName":"hssin",
  "firstName":"haythem",
  "birthday":"1995-01-24",
  "situationFamiliale":{
    "id": 1
  } 
}

http://localhost:9092/api/BankAccount/add
{ 
  "solde":"1800",
  "createDate":"2023-07-05",
  "customer":{
     "cin":14655144
  }
}

http://localhost:9092/api/DemandeCredit/add
{
  "montant":500,
  "nbreEcheance":5,
  "observation":"credit voiture", 
  "bankAccount":{"id":2},
  "unite":{"id":1},
  "typeCredit":{"id":1}
  
}

http://localhost:9092/api/NatureGuarantie/add
{
  "nom":"nature Garantie 1111"
}
http://localhost:9092/api/TypeCredit/add
{
  "nom":"Credit voiture"
}
http://localhost:9092/api/TypeGuarantie/add
{
  "nom":"Garantie tout les risques"
}
http://localhost:9092/api/PieceJointe/add
{
  "nom":"Cin",
  "type":"image",
  "typeCredit":{"id":1}
}
http://localhost:9092/api/Guarantie/add
{
  "valeur":5000,
  "devise":{"id":1},
  "natureGuarantie":{"id":1},
  "typeGuarantie":{"id":1},
  
  "demandeCredit":{"id":1}
}
