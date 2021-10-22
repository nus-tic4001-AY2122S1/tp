# Developer Guide

## Acknowledgements

- [docs.oracle.com Java time References](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalDateTime.html) 
- [Java Streams Reference](http://tutorials.jenkov.com/java-functional-programming/streams.html)
- Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft, *Modern Java in Action: Lambdas, streams, functional and reactive programming 2nd Edition*, Manning, 2018. 
- Team members: **Wan Yin, Hanna, Yeu Chai and Sze Chun**  


## Design & implementation

**JustBook Command Line App** leverages on the help of a total five Java classes, viz. **JustBook, Bookings, AddCommand, DeleteCommand and HelpCommand** created by the team. It takes advantage of an optimal use of Java Stream and latest java.time APIs, e.g. LocalDateTime and LocalDate, among others, together with a judicious choice of data structures, to allow a single user good at the keyboard to make and register bookings / appointments online fast. 

- Each user booking entry is stored in an `Arraylist<Bookings>` data structure (sorted before each displaym, allowing for editing or deleting functions onscreen). 
  
- The **Bookings** class will capture the user booking description, the scheduled start localDateTime and end localDateTime data of a specific booking. 
  
- Another data structure, `HashMap<LocalDate, LocalDate>`, is used to store, for efficient search/retrieval, a blocklist consisting of blocking periods where the user will not be able to make any bookings.  


## Product scope
### Target user profile

Target User: John

Age: 18 (typical)

Occupation: Student

Education: Currently in Poly or JC

Commitments: CCAs, recreational activities, Studies

Traits: Is technologically literate, active in activities, comfortable with typing commands

Our target user is a Student that is currently schooling. As an active student, the Target User has multiple activities that may be hard to keep track of. With the scheduler, John will be able to plan and organize multiple appointments at the same time.


### Value proposition

JustBook provides, throughout the app use, a consistent user-friendly and error-free interface, helpful message feedback or alerts. The scheduler can be customized into working on the basis of various time durations (6 months, monthly, weekly etc). Using the CLI-type interface, the user will be able to edit multiple appointments easily with minimal commands / single commands.

Users are able to make, check, delete, view, change, and source in real-time for available slots for appointments using this application. This application will display a range of time slots available for users to choose from, may also list available dates and unavailable dates when the User is trying to schedule an appointment. The User can also choose to work on a 6-calendar-months view/basis (an up and coming feature), or per month, per week, down to a day’s view/basis.  

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see help usage instructions|refer to them when I forget how to use the application|
|v1.0|regular user|I can add in a booking entry in one line|make an entry and have it stored online fast|
|v1.0|a quick user|I can edit a booking entry description|modify an entry description easily at will|
|v1.0|date planner|I find a booking item by date|locate a to-do without having to go through the entire list|
|v1.0|efficient student|I can order all my tasks and appointment by their due date|order all my tasks and appointment by their due date|
|v1.0|systematic student|I can see my list upfront |know what tasks I have clear for the day|
|v1.0|active student|I can view the block of outstanding schedules for the month displayed (coming feature)|check if I can add further bookings for that month|
|v1.0|fast-moving student|I can view the the day's block of remaining schedules|remind myself of the schedules done and which ones left to attend to that day|
|v1.0|studious student|I can input a blocking period into the database|so that I'm unable to book within that critical period|
|v2.0|student|I can save or load at start up my appointments and schedule|not need to re-create them everytime I log in|
|v2.0|structured student|I can see my appointments arranged together and tasks arranged together|have a clear distinct view of appointments and tasks|
|v2.0|student who always does late minute work|I want to see tasks or appointments going to be due being highlighted to me in ordered deadline date and time|can meet the deadline (coming feature)|
|v2.0|social student|I can view the block of weekend outstanding schedules for the entire current month displayed|check if I can add further bookings for the weekends|
|v2.0|busy student|I can quit the application immediately with an automatic save|move on to my other activities quickly|


## Non-Functional Requirements
1. Users are able to run the application as long as Java11 is installed
2. The application has been designed to handle up to 100’s of user appointments optimally without affecting its performance.
3. The application should preferably be executable on Windows OS or compatible software-emulated terminal.
4. User-friendly features incorporated in helpful messages feedback and diagnostic prompts (more to come) 


## Glossary

* *Mainstream OS* - Windows, Linux, Unix, OS-X
* *JustBook App*  - A single-user command line app for making and storing student bookings online 
* *CLI*           - Command Line Interface
* *booking*       - A typed entry consisting of booking text description, a start Date-Time and end Date-Time 
* *ISO(time)*     - For Java time Standards, it follows this format: "yyyy-MM-dd HH:mm"
* "Date-Time*     - Java LocalDateTime implemented with format as "yyy-M-d HH:mm", using a 24 hr format

## Instructions for manual testing

- Ensure Java jdk 11 is installed
- Download the justbook.jar file from Release v2.0
- Obtain a sample test file, eg. justbook.txt with saved entries (correctly formatted)
- Copy the sample test file to a local folder named data
- start up the app, eg.` java -jar justbook.jar` via a windows cmd or compatible terminal
- Type in a user name of your choice
- Type `show --all` or `show all` to check the display list tallies with those saved in the justbook.txt file
- Sample instruction:

<img width="552" alt="Screenshot 2021-10-22 at 12 40 41 PM" src="https://user-images.githubusercontent.com/88772711/138399952-42c4ebfa-ac1a-4a35-922b-c9979d7b1402.png">

