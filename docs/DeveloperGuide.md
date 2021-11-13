# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Delete feature
It extends `Command` class. It checks if the number input by user is out of range. If yes, error thrown. If no, the task will be deleted from the `TaskList`. `Ui` will print the response. 


<img src="https://user-images.githubusercontent.com/54061328/141602529-1b8bafe0-c4d5-4b3a-a37f-3cc05a76fe53.png" width="500">


### View feature
It extends `Command` class. If user input `-a` together with the command, `Ui` will print all the tasks in the `TaskList` together with the done status. If no,  `Ui` will print all the  **pending** tasks in the `TaskList` together with the done status.

<img src="https://user-images.githubusercontent.com/54061328/141602241-1b488747-bb15-4765-a166-92329cbb757e.png" width="500">


### Mark as done feature
It extends `Command` class. It checks if the number input by user is out of range. If yes, error thrown. If no, change the status of the task to done [X]. 

<img src="https://user-images.githubusercontent.com/54061328/141602402-9c7d0e5f-db45-499c-b1d3-387546ff3179.png" width="500">


## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|user|be able to delete a task if that task is not valid anymore|the task list is not cluttered|
|v1.0|user|see the responses from Daffy after I enter commands|know the commands are executed|
|v1.0|user|be able to see all tasks|plan my time|
|v2.0|user|be able to see unfinished tasks only|be more focus on the unfinished tasks|
|v2.0|user|mark tasks as done|track the progress|



## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
