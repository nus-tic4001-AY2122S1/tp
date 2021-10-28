# User Guide

## Introduction

EXPENSES MANAGEMENT SYSTEM (EMS) is a desktop app for managing expenses, optimized for use via a Command Line
Interface (CLI).

## Quick Start

1. Ensure you have java 11 or above installed in your computer.
1. Download the latest RMS.jar from [here](https://github.com/AY2122S1-TIC4001-F18-2/tp/releases).
1. Copy the file to the folder you want to use as a home folder for your Expenses Management System.
1. Double-click the file to start the app.
1. Type the command in the command box and press Enter to execute. e.g typing “list” and pressing Enter will show the
   list of expenses. <br/>
   Some example commands you can try:

* ```list ```: list all expenses.
* ```exit ```: exits the app.

## Features

* Adding an expense: expense
* Adding an income: income
* Listing all expense: list
* Delete an expense: delete
* Search for expense: find
* Exit the program: exit

### Adding an expense: `expense`

Adds a new expense item to the list of items.

Format: `expense`

* `description, category, amount, date`

Example of usage: <br/>
`expense` <br/>
Please key in the expense description:<br/>
`lunch` <br/>
Please key in the category: <br/>
`F&B` <br/>
Please key in the amount: <br/>
`15` <br/>
Please key in the date: <br/>
`2021-10-28` <br/>
Got it. I've added this item: <br/>
[E] [F&B] lunch ($15.0) (0034-Apr-13) <br/>
Now you have 1 items in the list. <br/>

### Adding an expense: `income`

Adds a new income item to the list of items.

Format: `income`

* `description, category, amount, date`

Example of usage: <br/>
`income` <br/>
Please key in the expense description:<br/>
`Company A` <br/>
Please key in the category: <br/>
`salary` <br/>
Please key in the amount: <br/>
`3000` <br/>
Please key in the date: <br/>
`2021-10-28` <br/>
Got it. I've added this item: <br/>
[I] [salary] Company A ($3000.0) (0034-Apr-13) <br/>
Now you have 1 items in the list. <br/>

###Deleting a Expense: `delete`

Delete existing expense record from the list of expense items.

Format: 
* Step I: key in `delete`
* Step II: key in `expense index` in integer type



### List an expense: `list`

list expenses items

Format: `income`

Here are the items in your list: <br/>
1.[E] [F&B] lunch ($15.0) (0034-Apr-13) <br/>
2.[E] [meal] dinner ($10.0) (0021-Nov-26)
Wourld you like sorting by expenses by amount
(Please key in sorting command: sort)

### Sort an expense: `sort`

sorting expenses by amount after `list` to display all expenses items

Format: `sort`

Sorting by ascending/ descending please type : asc or desc <br/>
`asc` <br/>
Here are the items in your list: <br/>
1.[E] [meal] dinner ($10.0) (26-Nov-2021)<br/>
2.[E] [F&B] lunch ($15.0) (03-Apr-20)<br/>
Wourld you like sorting by expenses by amount
(Please key in sorting command: sort)

Example of usage:

`Hi, I am Duke!`

`What can I help you?`

`delete`

`Please key in the index:`

`1`



## FAQ

**Q**: How do I transfer my data to another computer?

**A**: To run and show the data in another computer, you need to install the app in the other computer and overwrite the
empty data file it creates with the file that contains the data of your previous expenses folder.

## Command Summary

**Action** | **Format, Examples**
------------ | -------------
**Expense** | ```expense```, ```description, category, amount, date``` e.g.,```expense, lunch, F&B, 15, 2021-10-28 ```
**Income** | ```income```, ```description, category, amount, date``` e.g.,```income, Oct salary, Salary, 3000, 2021-10-28 ```
**List** | ```list ``` e.g., ```list ```
**Delete** | ```delete INDEX ``` e.g., ```delete 2 ```
**Find** | ```find KEYWORD ``` e.g., ```find lunch ```
**Exit** | ```exit ``` e.g., ```exit ```
**Sort** | ```sort``` e.g., asc or desc