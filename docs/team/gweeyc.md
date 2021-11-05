# Gwee Yeu Chai - Project Portfolio Page

## Project: JustBook App v3.0 Overview
JustBook - Version 3.0 is a desktop application typically designed for use by a modern poly or JC student, in 
registering his or her personal bookings or appointments. It leverages on an online database storage facility, backed by
an offline backup file. The user interacts with it using a CLI. It is written in Java(ver. 11), and has about 702 LoC.

### Summary of Contributions
- New Feature: `undel a` command - added the ability to undo a previous `del --all` (delete all) command.
  - What it does: allows the user to undo a previous clear all operation on the online database records.
  - Justification: This feature is to help a busy student user undo the mistake in command or decision made in haste,
    and the program should afford an easy way to recover from them. 
  - Highlights: This command is designed to work just after a previous delete all call, as well as several user entries
    later, so long as the `save`, `bye` or `exit` command has not been used.
  - Special feature: The above works in tandem with the deliberate add-in _append (file write)_ design in `add` command,
    so that the latest additions are all saved to the offline backup file and thus get restored from file, along with 
    previous records, upon command invocation.

- New Feature: `show we` command - displays only the month's weekends and book listings, in chronological order. 
    - What it does: allows the user to see at a glance if weekends are occupied or there are free slots for use.
    - Justification: This feature is to help a socially active student user zoom in on weekend(s) slots.
    - Highlights: This command is designed to display weekend dates nearest the point of entry date of the user. A 
      "Status: no bookings yet." visual message will be displayed under weekend slots with no bookings yet. 
    - Special feature: The commands works in tandem with the normal app functions with visual listings. 

- Code contributed: [Team04_gweeyc](https://tinyurl.com/TIC4001gweeycPPP)

- Project management:
    - Managed releases v1.0 - v3.0 (3 releases) on GitHub
    - Overall Administrator of Team Repo

- Enhancements to existing features:
    - Applied _ResolverStyle.STRICT_ condition on customized DateTimeFormatter patterns to ensure only valid dates are
      used
    - Designed in the append feature in `add` command to have a record of every new entry saved in the offline backup
      file (facilitates `undel a` more flexible usage, power outages or online disruption recovery)
    - Enabled logging and included assert statements where helpful
    - Made use of HashMap and Map.Entry APIs for fast storage, retrieval and compare operations in the creation of block
      list, unblocking functions and the policy on each new appointment entry date
    - listWeekends method, underpinning the `show we` command, had its particular search processes optimized so that
      unneeded searches are straightaway bypassed
    - Display of dates and appointment listings processes had been standardized, optimized for speed and designed to 
      work in synchronicity with all the program normal functions
    - The input date format was made flexible so user can enter in date digits without a '0' prefix if preferred.
    - Wrote new JUnit 5 tests for JustBookTest.java 
      (Pull request [#45](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/45)) 

- Documentation:
    - User Guide:
      - Added documentation for the features `show we` and `undel a`
      - Done the main format, overall template look and lines coding ([#32](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/32),
        [#33](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/33), [#34](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/34))
    - Developer Guide:
      - Added implementation details of the `show we` feature

- Community:
  - Kicked start the Project with the 1st. skeletal code framework the Team use for subsequent codings
  - Contributed to [forum discussions](https://github.com/nus-tic4001-AY2122S1/forum/issues?page=1&q=is%3Aissue+is%3Aclosed)
  - Overall admin duties enacted for the Team Repo setup, maintenance, operations and team encouragement
  - PRs reviewed ([#7](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/7),
    [#13](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/13), 
    [#25](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/25)) 

- Tools:
    - Integrated third party libraries 
      ([Guava & JUnit 5.8.1](https://github.com/AY2122S1-TIC4001-F18-4/tp/blob/master/build.gradle)) to the project
