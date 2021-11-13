# Developer Guide

## Acknowledgements

* [NUSMods API V2](https://api.nusmods.com/v2/)

## Design & implementation

**Overview**

![image](https://user-images.githubusercontent.com/43517460/141647688-eaeb4429-adce-4b07-8880-19a1ec8c8265.png)

**Command component**
![image](https://user-images.githubusercontent.com/43517460/141647430-0364958b-006a-407a-aa2e-873ea0b65c1b.png)

**Module component**
![image](https://user-images.githubusercontent.com/43517460/141647609-91b453de-9d9f-44f6-b72a-332efaa60474.png)



The Diagrams above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the App**

`Duke` is responsible for,

At app launch: Initializes the components in the correct sequence, and connects them up with each other.
At shut down: Shuts down the components.

The App consists of a few components.

`UI`: The UI of the App.
`Parser`: Parse instruction given by the user.
`Api`: Extract data from the NUSMOD API.
`Storage`: Reads data from, and writes data to, the hard disk.
`Module`: Contains information for Modules.
`Command`: The command executor.
How the components interact with each other

The Sequence Diagram below shows how the components interact with each other for the scenario where the user issues the command `list all`.
![image](https://user-images.githubusercontent.com/43517460/141649574-dde6abbc-4bb6-407e-82b1-90bf63017c47.png)


## Product scope
### Target user profile

NUS students who take modules, and prefer CLI.

### Value proposition

Module planning is a complex task which requires planning. Our app aims to let NUS students plan their upcoming modules more easily. 

## User Stories

|Version| As a ... | I want to ... | So that ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|I can refer to them when I forget how to use the application|
|v1.0|new user|download NMP for free from github|I will not incur any costs|
|v2.0|user|view a specific module|I can view module information that is relevant to me|
|v2.0|user|view my list of added modules|I can do a review of what modules I’ve been interested in|
|v2.0|user|remove modules from my list of added modules|my list will only contain the modules that I wanted|
|v2.0|user|view all modules offered for the term|I can bid for my modules|

## Non-Functional Requirements

- Each request should be processed within 3 seconds.
- Program to function properly on different operating systems.
- Program should have a 95 percent chance that the component can be fixed in 24 hours.
- Program should be available all time during a month.
- Program should not experience critical failure.



