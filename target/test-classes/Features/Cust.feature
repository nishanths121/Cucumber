
Feature: Add customer
  I want to use this template for my feature file

   Scenario: Title of your scenario
 #   Given User launch the browser
 #   When user clcik the add customer
 #   |fname|Nishanth|
  #  |lname|Samraj|
  #  |email|Nishanthsamrajj@gmail.com|
  #  |address|Coimbatore|
  #  |phno|9751200131|
  #  And user click the Add tariff Details.
   # |cusID|
  #  Then I validate the outcomes
    
Scenario Outline:
 Given user launch the browser
 When user clcik the add customer"<fname>","<lname>","<email>","<address>","<phno>"
 And user click the Add tariff Details.
 |cusID|
 Then I validate the outcomes
 
 Examples:
 |fname|lname|email|address|phno|
 |Nishanth|Samraj|nishanthsamraj@gamil.com|Coimbatore|9751200131|
# |vaishu|varun|vaishu@gmail.com|Coimbatore|9874563210|
 
 