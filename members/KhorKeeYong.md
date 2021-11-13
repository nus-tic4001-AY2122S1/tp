# Overview:

Air Rec is a desktop app for managing flight records, optimized for use via a Command Line Interface (CLI). User will not have to remember flight details and it can be found easily with commands.

## Code contributed:
https://nus-tic4001-ay2122s1.github.io/tp-dashboard/?search=kaydenkhor&breakdown=true&sort=groupTitle&sortWithin=title&since=2021-09-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other

- Created the base structure of the whole project code
- Integrated Gradle into project.
- Implemented Parser, FlightList, Flight class + enhancement to these classes.
- Implemented Add function + Upgraded Add function to be able to read in date and time format
- Enhanced Flight parameters 
- Upgraded Show all flights function
- Implemented Sort Function – To sort flight records by price and date time.
- Merging of all pull request so as to ensure all function are integrated smoothly (Includes bugs fixing, code reviews and manual code merging)
- Overall project code refactoring after each merge of PRs.
- J-Unit testing
- Proper branching and code tagging for team repo.


### Bugs fixing for:
-	Search function
-	Show all function
-	Show upcoming function
-	Storage class and auto save function (Spent most time on this) 
-	Delete function
-	Sort function



## Contributions to the UG:
Wrote all of the details of the user guide. From time to time, I have been updating the whole userguide.md file whenever I merge the PRs into the master repo. Although team mates have implemented function, but they didn’t update the UG or DG. Hence as I merge into the main repository, I update the UG from time to time. You can look at the amount of documents committed via my code contribution.

I set up and maintained the website for our repo as well as linking up all the relevant documents to our website like developerguide.md, userguide.md, aboutus.md.

## Contribution to DG: 
Drafted out the whole DG sections:
-	Acknowledgement
-	Design & Implementation
o	Included overall code UML Class diagram
-	Product scope (Update every version as our software develops…)
o	Target user profile
o	Value Proposition
-	User Stories (Update every version)
-	Non-functional Requirements
-	Glossary

Here's the UML class diagram:
![UML CLASS DIAGRAM](https://github.com/AY2122S1-TIC4001-F18-5/tp/blob/master/Diagrams/Overall%20Class%20Diagram.jpg)

Here's the sequence diagram when someone runs Air Rec:
![SEQUENCE DIAGRAM](https://github.com/AY2122S1-TIC4001-F18-5/tp/blob/master/Diagrams/Overall%20Sequence%20Diagram%20with%20Duke_run.png)


## Contributions to team-based tasks
-	Setting up the GitHub team org/repo
-	Necessary general code enhancements
-	Setting up tools e.g., GitHub, Gradle
-	Maintaining the issue tracker
-	Release management
-	Updating user/developer docs that are not specific to a feature e.g. documenting the target user profile
-	Incorporating more checkstyle plugin.
-	Setting & planning milestones
-	Presented software demos of v1.0 and v2.0 to professors. Shooting the demo video for v3.0.
-	Assigning task to team members as well as setting deadlines to hit milestones for v1.0, 2.0 and 3.0.
-	Bug fixing for team:
Storage class – dealing with the checkstyle, as well as the test-UI that caused the CI fail. Tested a few rounds to look out for more bugs and solve the bugs using exception handling as well as the way of implementation.
-	Enhancement:
Since I have enhanced the flight parameters to data parameters instead of strings especially the date time format, I have created extra methods to help team mates to grab data easily for their function implementation.

## Review/mentoring contributions:
-	Guided team mates to use proper branching for function implementation
-	Assigned team mates with issues and deadline
-	Gave feedbacks and comments on PRs whenever there is an issue with the CI or I see if there’s a better way of code implementation.



