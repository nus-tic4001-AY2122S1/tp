# User Guide

## Introduction

Daffy is a task tracker specifically built for computing students that are comfortable with the CLI. Working on improving and adding features to the existing Duke project and making it useful for students to manage their schedule and work. Natural language will be implemented to avoid exceptions due to typing errors.

## Quick Start

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Daffy` from [here](https://github.com/AY2122S1-TIC4001-F18-6/tp/releases/tag/v3.0).

## Features 

{Give detailed description of each feature}

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`


### Add Categories: `categories add`
Adds a new item to the list of categories.

Format: `categories add n/CATEGORY_NAME`

Example of usage:
`categories add fishes`

### Remove Categories: `categories delete`
Removes an existing item in the current list of categories.

Format: `categories delete n/CATEGORY_NUMBER`

* The `CATEGORY_NUMBER` must be an integer within the category list and it cannot be 0.

Example of usage:
`categories remove 1`

### View Categories: `categories view`
Prints the current list of existing categories.

Format: `categories view`

Example of usage:
`categories view`

### Tag Categories: `categories tag`
Tag an existing category to a task.

Format: `categories tag n/CATEGORY_NUMBER n/TASK_NUMBER`

* The `TASK_NUMBER` must be an integer within the category list and it cannot be 0.
* The `CATEGORY_NUMBER` must be an integer within the task list and it cannot be 0.

Example of usage:
`categories tag 1 1`


## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
* Add category `categories add n/CATEGORY_NAME`
* Remove category `categories remove n/CATEGORY_NUMBER`
* View category `categories view`
* Tag category `categories tag n/CATEGORY_NUMBER n/TASK_NUMBER`