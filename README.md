#### **Endpoint for Air Company**
1. http://localhost:8080/aircompanies  -- getAllAirCompanies
2. http://localhost:8080/aircompanies  -- createAirCompany

Body =
{
"name":"ArmeniaAir",
"companyType":"Transport",
"foundedAt":"2020-08-13"
}

3.  http://localhost:8080/aircompanies/1  -- deleteAirCompanyById
4.  http://localhost:8080/aircompanies/1  -- getAirCompany
5.  http://localhost:8080/aircompanies/3  -- updateAirCompany

Body =
{
"name":"MAY",
"companyType":"Transport",
"foundedAt":"2020-08-13"
}

#### **Endpoint for Airplane**

1. http://localhost:8080/airplanes/1?companyId=3 -- moveAirplaneBetweenCompany
2. http://localhost:8080/airplanes  -- addAirplane

Body =
{
"name":"Sirius",
"factorySerialNumber":"2222",
"airCompanyId":"1",
"flightDistance":"120",
"fuelCapacity":"300",
"type":"Transport",
"createdAt":"2020-01-12"
}

#### **Endpoint for Flight**

1. http://localhost:8080/flights/status?status=ACTIVE&companyName=ArmeniaAir -- getAllAirCompanyFlightsByStatus
2. http://localhost:8080/flights/active -- getAllByFlightStatusAndStartedTime
3. http://localhost:8080/flights -- addFlight
4. http://localhost:8080/flights/1/status?status=ACTIVE -- changeStatus
5. http://localhost:8080/flights/completed/bigger-then-estimate-- getAllCompletedFlightWhereStartedAndEndedBiggerThanEstimate  


**`For run the program, you need to up the docker-compose.yml file through the docker`**