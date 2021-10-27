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
* The `DATE TIME` uses format "yyyy-M-d" "HH:mm"  
* Current version allows within same day booking only
* User expected to input non-clashing same day timing ranges 

Example of usage: 

`add meet@Sports Hall One lvl 3 /s 2021-6-7 09:00 /e 2021-6-7 10:30`

`todo attend IT Exhibit Changi Expo Halls /s 2021-06-07 11:00 /e 2021-06-07 13:30`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary
['Cheat sheet' of commands]

* Add booking `add BOOKING_DESC /s DATE TIME /e DATE TIME`
