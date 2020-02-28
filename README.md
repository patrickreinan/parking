# Parking
Parking is a simple Java software built using TDD. We are using test-first method to add or change features. We want ensure that all the business rules are covered before implement software details (database, web, ui, etc).

## Requirements
* Java
* Clean Code
* SOLID principles
* Domain-Driven Design
* KISS
* YAGNI

## Phases
This project is being built in 3 phases:

+ <b>Phase 1</b> - Build domain layer and its unit tests.
+ <b>Phase 2</b> - Build application layer and integration tests.
+ <b>Phase 3</b> - Build infrastructure and end-to-end (e2e) tests.

## Scenario
A parking can have different pricing according how much time car stay parked in. Pricing is defined by time periods and these time periods can be combined. So we are considering just 3 rules:

## Pricing Type 1: 
+ Period until 1 hour: price is $1
+ Period until 2 hours: price is $2
+ Period until 12 hours: price is $10 
+ After 12 hours the price is added in $10 daily
 
<b>Example:</b>  
+ 3 hours: price is $10
+ 14 hours: price is $20 
+ 3 days: price is $40 

## Pricing Type 2: 
+ Each hour has a fixed price ($5)
 
<b>Example:</b> 
+ 3 hours: price is $15
+ 10 hours: price is $50

## Pricing Type 3: 
+ Period until 1 hour: price is $1
+ Period until 2 hours: price is $2
+ Period until 12 hours: each 1 hour period add $1 
+ After 12 hours the price is added in $10 by daily
 
<b>Example:</b>  
+ 3 hours: price is $3
+ 14 hours: price is $22 

# Solution
A application to simulate pricing.
