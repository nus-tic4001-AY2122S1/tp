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

Format: `add BOOKING_DESC /s DATE TIME /e DATE TIME`

* The `BOOKING_DESC` can be in a natural language format.
* The `DATE TIME` uses format *yyyy-M-d* *HH:mm*.  
* Current version allows within same day booking only.
* User expected to input non-clashing same day timing ranges.

Example of usage: 

`add meet@Sports Hall One lvl 3 /s 2021-6-7 09:00 /e 2021-6-7 10:30`

`todo attend IT Exhibit Changi Expo Halls /s 2021-06-07 11:00 /e 2021-06-07 13:30`


### Blocking date-range settings: `block <DATE> - <DATE>`
Blocks users from creating appointments during a specific date range.

Format: `block DATE - DATE`

* `DATE` uses format *yyyy-M-d*.
* Users may release blocked dates at their discretion _(e.g. via `unblock <date> - <date>`)_.

Example of usage:

`block 2021-11-5 - 2021-11-30`


### Deleting all bookings: `delete --all`
Erase all records inside the online appointment database.

Format: `delete --all`

* An alternate variant: `delete all`.

Example of usage:

`delete --all` or `delete all`


### Editing a booking: `edit`
Edits a chosen item's booking description (current v2.0).

Format: `edit BOOKING_DESC /s DATE /o OPTION NO.`

* The `BOOKING_DESC` can be in a natural language format.
* The `DATE` uses format *yyyy-M-d*.
* Current version allows editing the booking text-description only.
* `OPTION NO.` = to the serial no. of the booking item of a booking list display. 
* Before using `edit`, user is expected to open up first either
  - a specific date entries listing _(e.g. via `show <date>`)_ or 
  - the entire database listing _(e.g. via `show --all`)_.

Example of usage:

`edit meet@Sports Hall One lvl 3 /s 2021-6-7 /o 3`

`edit attend Exhibit A /s 2021-06-07 /o 1`


### Exiting Program: `exit`
Exits the JustBook App Program.

Format: `exit`

* An alternate variant: `bye`.

Example of usage:

`exit` or `bye`


### Showing a specific date's bookings: `show --all`
Displays all database records, headed by distinct dates header, in chronological order.

Format: `show -all`

* An alternate version: `show all`.

Example of usage:

`show --all` or `show all`


### Showing a specific date's bookings: `show <DATE>`
Displays all records chronologically, under a specific date header.

Format: `show DATE`

* `DATE` uses format *yyyy-M-d*.

Example of usage:

`show 2021-11-8`


### Showing a specific date's bookings: `show <WEEKENDS>`
Displays all records chronologically, under specific weekend headers, for the current month.

Format: `show WEEKENDS`

* `WEEKENDS` can be in a natural language format.

Example of usage:

`show weekends`


### Unlocking date-range settings: `unblock <DATE> - <DATE>`
Releases blocked dates during the range period as specified by users.

Format: `unblock DATE - DATE`

* `DATE` uses format *yyyy-M-d*.

Example of usage:

`unblock 2021-11-5 - 2021-11-30`


## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary
['Cheat sheet' of commands]

* Add booking `add BOOKING_DESC /s DATE TIME /e DATE TIME`
