# User Guide

## Introduction

**JustBook: An easy-to-use Appointment CLI App**

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `JustBook App` into your local folder from [here](https://github.com/AY2122S1-TIC4001-F18-4/tp/releases/tag/v3.0).
3. Open up a command or terminal window, _e.g._ [*Windows Terminal (recommended)*](https://www.microsoft.com/en-sg/p/windows-terminal/9n0dx20hk701?activetab=pivot:overviewtab), 
   from [inside the folder](https://www.lifewire.com/open-command-prompt-in-a-folder-5185505) or
4. cd to your local folder in your terminal

## Features 

Program designed for someone who are avid keyboarders,  for Single User use. 

### Load application: `java -jar justbook.jar`
Load application and all records from previous session (if any) inside the JustBook application.

**Format**: `java -jar justbook.jar`

<ins>**_Example of usage_**<ins>

`java -jar justbook.jar`

By calling this command, the JustBook application will load.

### Adding a booking: `add`
Adds a new item to the list of booking items.

**Format**: `add BOOKING_DESC /s DATE TIME /e DATE TIME`

* The `BOOKING_DESC` can be in a natural language format.
* The `DATE TIME` uses format *yyyy-M-d* *HH:mm*.
* Current version allows within-same-day booking only.
* Will first check whether booking entry date is allowed or denied using the BLOCKLIST database. 
* User expected to input reasonable non-clashing same-day timing ranges.
* _Add bookings that span days (coming feature)._
* _Will check whether there are clashing same-day timing ranges (coming feature)._ 

<ins>**_Example of usage_**<ins> 

`add meet@Sports Hall One lvl 3 /s 2021-6-7 09:00 /e 2021-6-7 10:30`

`todo attend IT Exhibit Changi Expo Halls /s 2021-06-07 11:00 /e 2021-06-07 13:30`


### Blocking date-range setting: `block <DATE> <DATE>`
Blocks users from creating appointments during a specific date range.

**Format**: `block DATE DATE`

* `DATE` uses format *yyyy-M-d*.
* Users may release blocked dates at their discretion _(e.g. via `unblock <date> <date>`)_.

<ins>**_Example of usage_**<ins>

`block 2021-11-5 2021-11-30`


### Deleting all bookings: `del --all>`
Erase all records inside the online appointment database.

**Format**: `del --all` 

* Alternate versions: `del a` or `del all`.

<ins>**_Example of usage_**<ins>

`del a`

### Deleting a single booking: `del <DATE> /o <OPTION_NUM>`
Erase all records inside the online appointment database.

**Format**: `del DATE /o OPTION_NUM` 

<ins>**_Example of usage_**<ins>
This will delete the first appointment that starts on 10th Oct 2020.
`del 2020-10-10 /o 1`

### Deleting a single booking: `help`
Erase all records inside the online appointment database.

**Format**: `help` 

<ins>**_Example of usage_**<ins>
By calling this command, the cheatsheet of commands will appear, allowing
`help`


### Delete appointments within date-range: `del /b <DATE> <DATE>`
Delete all records within specified date range.

**Format**: `del /b STARTDATE ENDDATE`

* `STARTDATE` and `ENDDATE` uses format *yyyy-mm-dd*.

<ins>**_Example of usage_**<ins>

`del /b 2021-11-5 2021-11-30`


### Save all appointments details up to this point: `save`
Save all records up to this point.

**Format**: `save`

<ins>**_Example of usage_**<ins>

`save`


### Editing a booking: `edit`
Edits the booking description of the chosen item.

**Format**: `edit BOOKING_DESC /s DATE /o OPTION NO.`

* The `BOOKING_DESC` can be in a natural language format.
* The `DATE` uses format *yyyy-M-d*.
* Current version allows editing the booking text-description only.
* _Edit the date and time slot, with possible scheduling conflict checking for user (coming feature)._
* `OPTION NO.` = the serial no. of an item under a booking list display. 
* Before using `edit`, user is expected to open up first either
  - a specific date entries listing _(e.g. via `show <date>` or `show weekends`)_ or 
  - the entire database listing _(e.g. via `show <--all>`)_.

<ins>**_Example of usage_**<ins>

`edit meet@Sports Hall One lvl 3 /s 2021-6-7 /o 3`

`edit attend Exhibit A /s 2021-06-07 /o 1`


### Exiting Program: `exit`
Exits the JustBook App Program.

**Format**: `exit`

* An alternate version: `bye`.

<ins>**_Example of usage_**<ins>

`exit` or `bye`


### Showing all bookings: `show <--all>`
Displays all database records, headed by distinct dates header, in chronological order.

**Format**: `show -all`

* Alternate versions: `show a` or `show all`.

<ins>**_Example of usage_**<ins>

`show a`


### Show appointments within date-range: `show /b <DATE> <DATE>`
Display all records within specified date range.

**Format**: `show /b STARTDATE ENDDATE`

* `STARTDATE` and `ENDDATE` uses format *yyyy-mm-dd*.

<ins>**_Example of usage_**<ins>

`show /b 2021-11-5 2021-11-30`


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
* An alternate version: `show we`.

<ins>**_Example of usage_**<ins>

`show we`


### Unlocking date-range setting: `unblock <DATE> <DATE>`
Releases blocked dates during the range period as specified by users.

**Format**: `unblock DATE DATE`

* `DATE` uses format *yyyy-M-d*.

<ins>**_Example of usage_**<ins>

`unblock 2021-11-5 2021-11-30`


### Undeleting a previous online database delete action: `undel <--all>`
Restore all records from offline appointment database up to current moment.

**Format**: `undel --all`

* Will restore all records from local archival file "/data/justbook.txt".
* So long as `save` command is not executed, it undoes all deletes or modifications up to current moment.  
* Alternate versions: `undel a` or `undel all`.

<ins>**_Example of usage_**<ins>

`undel a`


## FAQ

**Q**: How do I show all the bookings done for a range of days? 

**A**: you can refer to the _Show all bookings within two date_ in the Command Summary.

**Q**: How do I delete all the bookings done for a range of days?

**A**: you can refer to the _Delete all bookings within two date_ in the Command Summary.

**Q**: How do I save _all the bookings' modifications (incl. deletes)_ to offline database backup file on the go?

**A**: you can simply key in `save`.


## Command Summary
[ 'Cheat Sheet' of **CLI COMMANDS** - _case-sensitive_ ]

* Add booking: `add <BOOKING_DESC> /s <DATE> <TIME> /e <DATE> <TIME>`
* Block date range: `block <DATE> <DATE>`
* Delete all bookings: `del --all` or `del all` or `del a`
* Delete all bookings within two dates: `del /b <DATE> <DATE>`
* Delete a single appointment: `del <DATE> /o <OPTION_NUM>`
* Edit a booking description: `edit <BOOKING_DESC> /s <DATE> /o <OPTION NO.>`
* Exit the Program: `exit` or `bye`
* Save bookings to file: `save`
* Show all bookings: `show -all` or `show all` or `show a`
* Show a specific date's list of bookings: `show <DATE>`
* Show all bookings within two dates: `show /b <DATE> <DATE>`
* Show all weekends bookings (for current month): `show <weekends>` or `show we`
* Unlock a blocked date range: `unblock <DATE> <DATE>`
* Undelete a previous online database delete action: `undel a`
* Requiring help with commands: `help`