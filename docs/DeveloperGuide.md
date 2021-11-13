# Developer Guide

## Acknowledgements

Thanks to NUS fundamental code of DUKE. We are creating AIRREC as a modification of Duke project.

## Design & implementation

We will be using Duke as our main class to greet, run and exit the whole chat bot. (Take note, we want to remain "Duke" as our main class just to give credits to the base code)

The run() is a while loop which it is always waiting for user's input.

Any exception caught will still be remained in the while loop until the user types "bye".

When user inputs a string, AirRec will pass the string to Parser class to parse it into readable commands for AirRec.

Air Rec will use a switch case to execute the different types of commands received.

After which, any message or UI display will be handled by Message Class.

In the whole run sequence, there will always be 1 Flight list only, another instant of Flight list act as a temporary list when we are doing date compare or storage.

Here's the UML class diagram:
![UML CLASS DIAGRAM](Overall%20Class%20Diagram.jpg)

Here's the sequence diagram when someone runs Air Rec:
![SEQUENCE DIAGRAM](Overall%20Sequence%20Diagram%20with%20Duke_run.png)

## Product scope
### Target user profile

All flight passengers who travel frequently and needs a place to store flight details so that they don't have to re-visit the website to pull out the results of their searched flights again.

Persona:
Jean is an international university student studying in bachelor of computer engineering in NUS. She flies back to Australia every semester vacation throughout her studies in NUS. Every time she books an airline ticket, she needs to spend an hour to find the best flight timing so that her family back home can fetch her in the morning during the weekend.

While booking the flight, she went through multiple rounds of the traditional flight booking process on the airline website.

### Value proposition

1. Time wastage.

Currently with the DIY booking system, it takes time for user to navigate around the booking system to find & select their desired flight bookings. With this chatbot, users can specify their destination, desired time of arrival, price of the ticket... etc. the chatbot will automatically pull out flight bookings that they have saved for them.



2. Non-flexible booking.

Traditional booking system is a one-way process, whenever a user needs to make changes to their criteria while searching for flights, they have to repeat the whole process again. With this chatbot, it grants the user to immediately pull out the flight details that they have saved before so that they can EDIT the flight records and don't have to go back all the way from the start like the traditional booking system. 



3. Quick access to Flight records.

After having a list of flight records, it's difficult to read line by line. With AirRec, users have the power to SEARCH, SORT BY DATE&TIME/ PRICE as well as see the UPCOMING flight as compared to their current local time instantly. This has greatly reduce the process of searching for flight.



4. Lack of a quick solution while problems occurred during flight booking.

We will also include answers to common FAQs in regards to FLIGHT BOOKING only. We do not want to go out of scope to become a HELPDESK chat bot.

## Overview of the system - Sequence Diagram
![sequence diagram drawio (1)](https://user-images.githubusercontent.com/54314980/140071853-ff64cdd3-3445-4f71-b2bd-4e96229589f9.png)

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|Be greeted by application “Hi passenger, welcome to Air Rec!” |Be aware that the application is running.|
|v1.0|user|store a flight detail  |Not forget about the details.|
|v1.0|user|Delete a flight detail  |Free up the list.|
|v1.0|user|View all saved trip   | Refer to the past flights that I've intended to book previously.|
|v2.0|user|find a flight in my list|I don't have to go through the whole list to find my flight|
|v2.0|user|save my flight into meaningful data| I can use it for reference to current time|
|v3.0|user|save my list even when I exit the program| pull out the same list again the next time I run the program.|
|v3.0|user|show the flight that is nearest to the current time| be aware of which flight to book first.|
|v3.0|user|Sort my flight list by price| see which one is the cheapest flight.|
|v3.0|user|Sort my flight list by date time| see which one is the earliest flight.|

## Non-Functional Requirements

NFR-1: Able to work any mainstream OS as long as it has Java 11 or above installed.
NFR-2: Able to save at least 1000 flight records.
NFR-3: AirRec is able to response within 3 seconds.

## Glossary

* *Mainstream OS* - Windows, Linux, Unix, Mac-OS.

