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

## Features 

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

### Adding a module: `add`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
