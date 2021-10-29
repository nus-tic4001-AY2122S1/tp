# User Guide

## Introduction

**JustBook: An easy-to-use Appointment CLI App**

## Quick Start

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `JustBook App` from [here](https://github.com/AY2122S1-TIC4001-F18-4/tp/releases/tag/v2.0).

## Features 

Program designed for someone adept with the keyboard, for Single User use. 

### Adding a booking: `add`
Adds a new item to the list of booking items.

**Format**: `add BOOKING_DESC /s DATE TIME /e DATE TIME`

* The `BOOKING_DESC` can be in a natural language format.
* The `DATE TIME` uses format *yyyy-M-d* *HH:mm*.  
* Current version allows within same day booking only.
* User expected to input non-clashing same day timing ranges.

<ins>**_Example of usage_**<ins> 

`add meet@Sports Hall One lvl 3 /s 2021-6-7 09:00 /e 2021-6-7 10:30`

`todo attend IT Exhibit Changi Expo Halls /s 2021-06-07 11:00 /e 2021-06-07 13:30`


### Blocking date-range setting: `block <DATE> - <DATE>`
Blocks users from creating appointments during a specific date range.

**Format**: `block DATE - DATE`

* `DATE` uses format *yyyy-M-d*.
* Users may release blocked dates at their discretion _(e.g. via `unblock <date> - <date>`)_.

<ins>**_Example of usage_**<ins>

`block 2021-11-5 - 2021-11-30`


### Deleting all bookings: `delete <--all>`
Erase all records inside the online appointment database.

**Format**: `delete --all`

* An alternate version: `delete all`.

<ins>**_Example of usage_**<ins>

`delete --all` or `delete all`


### Editing a booking: `edit`
Edits the booking description of the chosen item (current v2.0).

**Format**: `edit BOOKING_DESC /s DATE /o OPTION NO.`

* The `BOOKING_DESC` can be in a natural language format.
* The `DATE` uses format *yyyy-M-d*.
* Current version allows editing the booking text-description only.
* `OPTION NO.` = the serial no. of an item under a booking list display. 
* Before using `edit`, user is expected to open up first either
  - a specific date entries listing _(e.g. via `show <date>`)_ or 
  - the entire database listing _(e.g. via `show <--all>`)_.

<ins>**_Example of usage_**<ins>

`edit meet@Sports Hall One lvl 3 /s 2021-6-7 /o 3`

`edit attend Exhibit A /s 2021-06-07 /o 1`


### Exiting Program: `exit`
Exits the JustBook App Program.

**Format**: `exit`

* An alternate variant: `bye`.

<ins>**_Example of usage_**<ins>

`exit` or `bye`


### Showing all bookings: `show <--all>`
Displays all database records, headed by distinct dates header, in chronological order.

**Format**: `show -all`

* An alternate version: `show all`.

<ins>**_Example of usage_**<ins>

`show --all` or `show all`


### Showing a specific date's list of bookings: `show <DATE>`
Displays all records chronologically, under a specific date header.

**Format**: `show DATE`

* `DATE` uses format *yyyy-M-d*.

<ins>**_Example of usage_**<ins>

`show 2021-11-8`


### Showing all weekends bookings (current month): `show <WEEKENDS>`
Displays all weekend records chronologically, under specific weekend headers, for the current month.

**Format**: `show WEEKENDS`

* `WEEKENDS` can be in a natural language format.

<ins>**_Example of usage_**<ins>

`show weekends`


### Unlocking date-range setting: `unblock <DATE> - <DATE>`
Releases blocked dates during the range period as specified by users.

**Format**: `unblock DATE - DATE`

* `DATE` uses format *yyyy-M-d*.

<ins>**_Example of usage_**<ins>

`unblock 2021-11-5 - 2021-11-30`


## FAQ

**Q**: How do I show all the bookings done for a range of days? 

**A**: you can refer to the _Show all bookings within two date_ in the Command Summary.

**Q**: How do I delete all the bookings done for a range of days?

**A**: you can refer to the _Delete all bookings within two date_ in the Command Summary.

**Q**: How do I save all the bookings on the go?

**A**: you can simply key in `save`.


## Command Summary
[ 'Cheat sheet' of **<ins>CLI COMMANDS<ins>** - _case-sensitive_ ]

* Add booking: `add <BOOKING_DESC> /s <DATE> <TIME> /e <DATE> <TIME>`
* Block date range: `block <DATE> - <DATE>`
* Delete all bookings: `delete --all` or `delete all`
* Delete all bookings within two dates: `del /b <DATE> <DATE>`
* Edit a booking description: `edit <BOOKING_DESC> /s <DATE> /o <OPTION NO.>`
* Exit the Program: `exit` or `bye`
* Save bookings to file: `save`
* Show all bookings: `show -all` or `show all`
* Show a specific date's list of bookings: `show <DATE>`
* Show all bookings within two dates: `show /b <DATE> <DATE>`
* Show all weekends bookings (for current month): `show <weekends>`
* Unlock a blocked date range: `unblock <DATE> - <DATE>`
