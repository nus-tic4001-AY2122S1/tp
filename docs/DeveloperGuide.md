# Developer Guide

## Acknowledgements

- [docs.oracle.com Java time References](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalDateTime.html) 
- [Java Streams Reference](http://tutorials.jenkov.com/java-functional-programming/streams.html)
- Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft, *Modern Java in Action: Lambdas, streams, functional and reactive programming 2nd Edition*, Manning, 2018.   


## Design & implementation

**JustBook Command Line App** leverages on the help of a total five Java classes, viz. **JustBook, Bookings, AddCommand, DeleteCommand and HelpCommand** created by the team. It takes advantage of an optimal use of Java Stream and latest java.time APIs, e.g. LocalDateTime and LocalDate, among others, together with a judicious choice of data structures, to allow a single user good at the keyboard to make and register bookings / appointments online fast. 

- Each user booking entry is stored in an `Arraylist<Bookings>` data structure (sorted before each displaym, allowing for editing or deleting functions onscreen). 
  
- The **Bookings** class will capture the user booking description, the scheduled start localDateTime and end localDateTime data of a specific booking. 
  
- Another data structure, `HashMap<LocalDate, LocalDate>`, is used to store, for efficient search/retrieval, a blocklist consisting of blocking periods where the user will not be able to make any bookings.  


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements
1. Users are able to run the application as long as Java11 is installed
1. The application has been designed to handle up to 100’s of user appointments optimally without affecting its performance.
1. The application should preferably be executable on Windows OS or compatible software-emulated terminal.
2. User-friendly features incorporated in helpful messages feedback and diagnostic prompts (more to come) 


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
