# User Guide

## Introduction

This User Guide will get GTD users started on the commands that achieve common GTD actions. 

## Quick Start

1. Ensure that you have Java 11 or above installed
2. download the `.jar` file at [this link release V3.0](https://github.com/AY2122S1-TIC4001-F18-3/tp/releases/tag/v3.0)  put to desired directory 
3. `cd` to the directory contains the `.jar` file 
4. ```
   java -jar tp.jar
   ```
   
Alternative way of installing the program: 
2. ```
   git clone https://github.com/AY2122S1-TIC4001-F18-3/tp.git
   ```
3. This way you will get pre-loaded sample tasks when start the program
4. You could open the folder as a project via IDE

## Features 

Common GTD features such as 
+ dump all thoughts into Inbox
+ sort items in Inbox to Next, Project, Wait for, Someday
+ put items from Inbox to be under a Project 
+ mark actionable item as Done 

## Rules
There are some rules to be followed to align with the spirit of GTD:
- Those tasks sorted to `NEXT`, means they are actionable items (can be completed in one step), so they should not have any subtasks, in other words, they can't be a project.
- There are maximum 2 layer of nesting, meaning the ref_no. of a tasks when `list proj` can be e.g. `1`, `1-1`, `1-1-1`, no further nesting is allowed

### Add to Inbox: `add`
Add a task to inbox.

Format: `add THOUGHT_TITLE`

Example of usage:

`add task1`

`add get report from @Alain`

### List items in Inbox: `list`
List tasks in inbox.

Format: `list inbox`

### List items with Status: `list`
List tasks filtered by status (`NEXT`, `PROJ`, `WAIT`, `SOME`, `DONE`).

Format: `list STATUS`

Example of usage:

`list NEXT`

`list WAIT`

## Set to Status
Set tasks to a status (`NEXT`, `PROJ`, `WAIT`, `SOME`, `DONE`).

Format: `set TASK_REF_NO... STATUS`

Example of usage:

`set 1 NEXT`

### Set due date: `due`
Set due date to a task or tasks.

Format: `due TASK_REF_NO... YYYY-MM-DD`

Example of usage:

`due 1 2021-11-13`

### Inbox items to Project Arrangement: `proj-mode`

Remember to `set` top level (no indentation) PROJ from Inbox first, 
while subproject can be added in `proj-mode`.

Format: 

`proj-mode`

`INBOX_REF_NO -> PROJ_REF_NO`

`q`

Example of usage:

```
proj-mode
3 -> 2
1 2 -> 1-2
q
```
(the Exception handling for `proj-mode` yet made it into V3.0, incorrect arguments result in exiting `proj-mode` immediately)

### Delete a task: `delete`
Delete a task from current/latest displayed list.
(When doubt, always list the desired list first)

Format: `delete TASK_REF_NO...`

Example of usage:

`delete 3`

`delete 1 2`

`delete 1-1-3 1-2`

### Mark a task done: `done`
Complete a task from current/latest displayed list.
(When doubt, always list the desired list first)

Format: `done TASK_REF_NO...`

Example of usage:

`done 1 2`

`done 1-2-2`

### Exiting the program: `bye`
Exits the program

Format: `bye`

### Saving the data
Project Next data are saved in the hard disk automatically after any command that changes the data, when the directory doesn't exist the program will automatically create the path, there is no need to proceed manually.

### Stored data file
Project Next used text file to store the data, if you are an advanced user, please free to update the data directly by editing the text file, but take note the format is
```
id|status|task title|due date|||parent id(s)
```
e.g.
```
25|NEXT|meeting deliverable 1|2021-11-06|||14|24|
```
## FAQ

**Q**: Where is the plain text data file stored 

**A**: `./data/next.txt`

## Command Summary

  | Functions  | Commands |
  | ------------- | ------------- |
  | Add to Inbox  |   `add THOUGHT_TITLE` |
 |  List items in Inbox | `list inbox` |
  | List items with Status  | `list STATUS` |
  |  Set to Status  | `set TASK_REF_NO... STATUS`|
  |  Set due date | `due TASK_REF_NO... YYYY-MM-DD` |
  |  Arrange items from Inbox to under a project | [suggest `set` items that supposed to be PROJ (top level with no indentation) from Inbox first] <br /> `proj-mode` <br /> `INBOX_REF_NO -> PROJ_REF_NO`<br />to exit<br />`q` |
 |  Mark tasks done | `done TASK_REF_NO...` |
  | Delete a task  | `delete TASK_REF_NO...` |
  | Exit program  | `bye` |
