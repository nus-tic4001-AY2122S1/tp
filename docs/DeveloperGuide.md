# Developer Guide - Draft V0.2

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries 
-- include links to the original source as well}

To be update: 

?[address book](https://github.com/se-edu/addressbook-level3)

## Design & implementation

### UML

### Code snippets

## Product scope
### Target user profile
Daily GTD users who are enthusiastic about organizing tasks digitally and being exceptionally productive. 
Compared to tapping on the todo apps with GUI on their phones, they would prefer typing command lines for
speed of the batch editing and minimum visual distractions.

### Value proposition
Todo apps on the market generally target a broad customer base including light users, 
which means the learning curve is low and hard core features are hidden to not overwhelm the new users; 
They want the app to be flexible to accommodate more users who could use the app in their own ways, 
which results in difficulties to set up a proper GTD flow and clutters due to extra features; 
They have user-friendly interface and visual elements transiting with animation, 
those designs are key attractions to many, however, for power users, UI, gestures, 
animation may not be the most efficient and slower compared to old plain text entry.

The value offered by Project Next is to offer a quick text entry and batch editing command line REPL 
environment for the users who choose practicality over goofy aesthetics. Our product strictly follows 
the GTD method to provide handy guides and workflow to empower users to stick with the rhythm to check 
off tasks and accomplish life goals.

### User Persona

Alex is a 28-year old Project Manager who works at a software company. She overlooks multiple coding projects via GitHub. She is responsible to ensure all of them are on track to meet the release schedule. She often has an operational meeting in the morning to bring up daily deliverables and encountered issues. She meets and calls people in charge from different departments to check on the status of their work. If there is any issue in the progress, she may need to coordinate or make changes to the project planning.

Being a productivity guru in the company, she has always been researching for better ways to manage her daily tasks. Presently she is a Get Things Done (GTD) enthusiast. By practicing with the methodology originally introduced by David Allen, she feels very empowered that she could get more work done rather than filling more dead todos lying in a list forever.

Working in a tech company, she sure is tech savvy. She is constantly looking for new tools that would better suit her needs, e.g. enable her to note down ideas quickly, typing centric input experience etc.



## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|Todo app user|set a task as DONE at completion|I can see my progress on my task achievement|
|v1.0|GTD user|set actionable tasks in my Inbox as NEXT|those tasks get removed from Inbox and allow me to refer to the Next list for action|
|v1.0|GTD user|set the actionable tasks in my Inbox that cannot be performed by me until relevant resources from someone else as WAIT|review them again in one place once I obtain the deliverables from the person in charge|
|v2.0|GTD user|set the non-actionable tasks in my Inbox that cannot be done in one step as PROJ|later I could plan for each project and dismantle them into a sequence of actionable tasks|
|v2.0|GTD user|move actionable tasks from Inbox to be under a specific project which it belongs to|I could clear my Inbox and have tasks grouped in a logical way|

## Non-Functional Requirements
+ program shouldn't just crash because user keys wrong words
+ program jar file should not rely on OS specific API, should run on OS with JDK 11 
+ 


## Glossary
+ *GTD* - [Get Things Done](https://todoist.com/productivity-methods/getting-things-done#what-is-gtd-a-brief-overview)
+ *GtdThought* - the data structure of a task which has a Status, can have parent GtdThought which holds it or hold multiple GtdThought as children
+ *GtdList* - a list that holds 0 to multiple GtdThought
+ *glossary item* - Definition
+ *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

### add a task to inbox 
```
add This is a Task with Title
```
### list inbox, next, proj, wait, some
```
list proj
```
### set task status
```
set 1 3 next
```
### move tasks from inbox to be under a proj via proj-mode
```
proj-mode
_________________________________________________
begin proj-mode >>>
use `#no #no .. -> #no` to move from left to right

inbox: ..................... proj:
1 issue#53v1 ............... 1 [PROJ] tp
2 merge PR about ListCmd ...... 1-1 [PROJ] features under me
3 write tp agenda wk11 ........ 1-2 [PROJ] PR review
4 call Alex ................... 1-3 [NEXT] call RT on parser
5 but cat food ............. 2 [PROJ] quarterly meeting

1 -> 1-1

q
end proj-mode <<<
```
