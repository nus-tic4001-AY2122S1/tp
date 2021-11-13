# User Guide

## Introduction

NUS Mods List is a program to help you choose and organize your NUS modules.

You can view all available modules for the year, as well as add modules you are interested in to your personal list of modules. NUS Mods List also lets you save and load your list, so you can log off the program, log in another time, and still be able to keep the modules you have saved the last time.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
2. Down the latest version of `Duke` from [here](https://github.com/nus-tic4001-AY2122S1/tp).
3. Start the program by running the .jar file. When the program is running, you should see this output:
`Welcome to NUS module tracker`

`What can I do for you?`

`Type something:` 

4. You can now enter commands into the command prompt. 

## Features / Command Summary

Here are a list of commands you can enter, and the explanations of what the commands do:

| Command           | Description                                                                                                                               |
|-------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| list all          | View all available modules for the year.                                                                                                  |
| list <ModuleCode> | View a list of module and its basic information. For example, use `list TIC1001` to filter and view a list of modules containing TIC1001. |
| add <ModuleCode>  | Adds a module to your personal list. For example, use `add TIC1001` to add TIC1001 to your personal list                                  |
| delete <Index>    | Deletes a module from your personal list by index. For example, use `delete 1` to delete the first module in your personal list.          |
| save              | Saves your current personal list.                                                                                                         |
| load              | Loads your saved personal list.                                                                                                           |
| myList            | Views your personal list.                                                                                                                 |
| view <ModuleCode> | Views a more detailed information of a more specific module. For example, use `view TIC1001` to view the module details.                  |

### Listing available modules: `list all`

Format: `list all`

Example of Usage: 
```console
Type something: list all
Here are the list of available Modules (Limit to 10) : 
AA1201 | Asian Challenges and Interconnections | Semester:1 | Exam date:null | Exam duration:null
AC5001 | Architectural History of Singapore | 
AC5002 | Conservation Approaches and Philosophies | Semester:2 | Exam date:null | Exam duration:null
AC5003 | Urban Conservation and Regeneration | Semester:2 | Exam date:null | Exam duration:null
AC5004 | Architectural Heritage Management | Semester:2 | Exam date:null | Exam duration:null
AC5005 | Conservation Policy Methodology for Sustainable Development | Semester:2 | Exam date:null | Exam duration:null
AC5006 | Disaster Risk Management of Cultural Heritage | 
AC5007 | Dissertation | 
AC5008 | Design for Conservation | 
AC5009 | Design for Adaptive Reuse | 
AC5010 | Historic Buildings Survey and Recording | Semester:2 | Exam date:null | Exam duration:null
AC5011 | Conservation of C20th Buildings | 
AC5012 | Practical Building Conservation Skills I | 
AC5013 | Practical Building Conservation Skills II | 
AC5014 | Internship | 
* Data was retrieved using NUS MODS API. *
```
### Searching for Modules: `list <Module Code>`

Format: `List <Module Code>`

* The `List <Module Code>' command can work on fuzzy search. 
* You can search with a partial Module code it would return a list of results instead.  

Example of usage: 
```console
Type something: list TIC40
TIC4001 | Software Engineering Practicum I | Semester:1 | Exam date:null | Exam duration:null
TIC4002 | Software Engineering Practicum II | Semester:2 | Exam date:null | Exam duration:null
TIC4003 | Software Project Management | Semester:2 | Exam date:Fri May 07 01:00:00 UTC 2021 | Exam duration:120
TIC4004 | Software Quality Control | 
TIC4005 | Parallel and Distributed Software Engineering | Semester:1 | Exam date:Wed Dec 02 01:00:00 UTC 2020 | Exam duration:120
```

### Detailed information of a Modules: `view <Module Code>`

Format: `view <Module Code>`

Example of usage:
```console
Type something: view TIC4001
TIC4001 | Software Engineering Practicum I | Semesters:  | This module is one of the two modules where students get to practice software engineering concepts learnt in a team environment to produce a well-designed, well-tested, large-scaled software system. This module focuses on software engineering practice of a greenfield project, where students will elicit the requirements, design the software architecture and interfaces, and implement the software from scratch. | Module credit: 4.0 | Department: SCALE Dean's Office | Faculty: Cont and Lifelong Education | Prerequisites: TIC3001 | Corequisites: null | Detailed semester data:Semester:1 | Exam date:null | Exam duration:null
```

### Adding a module into your list: `add <Module Code>`

Format: `add <Module Code>`

* Only 1 module code can be added at a time

Example of usage:
```console
Type something: add TIC4001
Got it. I've added this module:
TIC4001 - Software Engineering Practicum I
Now you have 1 modules in the list.
```

### View your own List of modules: `mylist`

Format: `mylist`

* Displays list of modules that you have added.

Example of usage:
```console
Type something: mylist
Here are the modules in your list: 
TIC4001 - Software Engineering Practicum I
```
### Delete a module from your list: `delete <Index>`

Format: ` delete <Index>  `

* Removes an added module in your list.
* `<Index>` denotes the position of the module in your list. e.g `delete 1` deletes the first module in your list.

Example of usage:
```console
Type something: delete 2
Noted. I've removed this module:
TIC4002 - Software Engineering Practicum II
Now you have 1 modules in the list.
```

### Save or load current your lists: `save` / `load`

Format: `save`

* Saves the current state of your module list.
* To be used in conjuction with `load`

Format: `load`

* loads the saved state to your user list.

Example of usage:
```console
Type something: save
Saved modules to user_modules.json

Type something: load
Loaded modules from user_modules.json

Type something: mylist
Here are the modules in your list: 
TIC4001 - Software Engineering Practicum I
TIC4002 - Software Engineering Practicum II
TIC4003 - Software Project Management
```
