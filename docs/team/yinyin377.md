# Lim Wan Yin - Project Portfolio Page

## Project: JustBook App v3.0 Overview
JustBook - Version 3.0 is a desktop application typically designed for use by a modern poly or JC student, in 
registering his or her personal bookings or appointments. It leverages on an online database storage facility, backed by
an offline backup file. The user interacts with it using a CLI. It is written in Java(ver. 11), and has about 702 LoC.

### Summary of Contributions
- Feature: `save` command - the ability to save all bookings or appointments up to point of saving.
   - What it does: helps the user to save records up to saving point.
   - Justification: This feature is to help a student user save their work fast on the go.
   - Highlights: This command helps to save existing records, after any command to modify has been used.

- Feature: `onLoad` command - load all bookings or appointments records from previous sessions.
  - What it does: allows the user to load all the bookings or appointment so that user do not have to re-input appoinment details.
  - Justification: This feature is to help a busy student user to load appointments without the need to enter all details again.

  - Code contributed: [Team04_yinyin377]

  - Project management:

  - Enhancements to existing features:
  - JUnit tests for RangeCommandTest.java