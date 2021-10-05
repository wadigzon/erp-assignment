# erp-assignment
Repo for my assignments from ERP International LLC

Question1
Gets the list of prime numbers up to an input given

Question2
Adds some new Employee

Solution for Question1:

Source code for Server (Rest API) can be found at ./question1/server
Source code for Client (React Front End) can be found at ./question1/client

To execute Server Rest API:
- go to server directory (mentioned above) and run
- $ mvn spring-boot:run

To execute Server Unit Test (server API must be running):
- go to server directory and run
- $ mvn test

To execute Client (Server must be running)
- go to client directory and run
- $ yarn start
- put a number on the input field, and click on next button, you should see the list of primes (and the number of primes) displayed in a single message.
- note that there's some validation, if the input field is empty or if there's not a numeric value there the next button (to get numbers) will not be enabled.
