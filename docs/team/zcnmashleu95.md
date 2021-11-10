# Lam Sze Chun - Project Portfolio Page

## Project: JustBook App v3.0 Overview
JustBook - Version 3.0 is a desktop application typically designed for use by a modern poly or JC student, in 
registering his or her personal bookings or appointments. It leverages on an online database storage facility, backed by
an offline backup file. The user interacts with it using a CLI. It is written in Java(ver. 11), and has about 702 LoC.

### Summary of Contributions
- New Feature: deleting a single appointment
  - For this feature, I implemented this in the DeleteCommand Class. This feature allows the user to delete a specific appointment
  at a specific date. This is useful if the user wishes to delete an appointment from the schedule.

- New Feature: providing instructions for the "help" command
    - This feature is implemented in the HelpCommand Class. This feature prints out instructions about how the command works. This is useful for the user
    if the user has forgotten what are the available commands.

- Code contributed: [Team04_zcnmashleu95](https://tinyurl.com/e2ksmuvb)

- Project management:
    - Helped to assist teammates in their enquiries

- Enhancements to existing features:
    - Added a new job under gradle "Perform all Regression Tests" uunder gradle.yml
    - Added the concurrency option for JUnit tests under build.gradle (they will run faster)
    - Refactored the delete, edit and add features into Command classes for better testability and cohesion.
    - Wrote the JUnit tests for AddCommand, DeleteCommand and EditCommand
    - Refactored the script for the IO/Regression test to be scalable. Additional test cases can be added more easily and executed via 1 script. 
    

- Documentation:
    - User Guide:
      - Added documentation for the features "help and "deleting a single appointment"
    - Developer Guide:
      - Edited Target User Profle, Design Section and the testing section
    - Added Class and Sequential Diagram 2
- Community:
  - PRs reviewed : 
  1) https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/8 
  2) https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/10
  3) https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/29

