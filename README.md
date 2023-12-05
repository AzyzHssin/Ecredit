# Ecredit-FrontEnd

http://localhost:9092/api/SituationFamiliale/add
{
  "situation":"Marié(e)"
}

http://localhost:9092/api/Unite/add
{
  "nom":"TND"
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
  "Observation":"credit voiture", 
  "bankAccount":1,
  "Unite":1
  
}

