# Core Banking System
Project Title: Loan Lifecycle Engine

Objective:  
Build a Java application that simulates a real loan management backend. The system should support customer onboarding, loan application processing, loan approval/rejection, loan account creation, disbursement, repayment schedule generation, repayment processing, overdue handling, penalty application, and loan closure.

Technical constraints:  
- Pure Java only
- In-memory persistence only
- Layered design mandatory
- Future migration to Hibernate and Spring Boot must remain easy

Required architecture:  
- model
- enums
- repository
- repository.impl
- service
- service.impl
- exception
- util
- app

Rules:  
- No business logic in main
- Use repository interfaces
- Use in-memory repository implementations
- Use enums for statuses
- Use LocalDate for date handling

First deliverable:  
Before implementation, submit:
1. Entity list  
2. Class list by package  
3. Responsibility mapping  
4. Main workflows  
5. Business assumptions  
6. Edge cases

Main business modules:  
- Customer Management  
- Loan Application  
- Loan Account  
- Disbursement  
- Repayment Schedule  
- Payment Allocation  
- Overdue and Penalty Handling  
- Loan Closure

Expected final output:  
A working console-based Java system with clean architecture, realistic business rules, and code ready for future migration to DB-backed and service-based architecture.
