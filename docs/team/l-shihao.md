# Li Shihao's Project Portfolio Page

## Project NEXT
Project NEXT provides a quick command line tool for GTD enthusiasts and daily practitioners who prefer the speed of text input.

It provides commands to add tasks into Inbox, and set tasks as Next, Wait, Some(day), Proj(ect), Done. Project can have maximum of 2 layers of nesting. Users can easily put tasks from Inbox to be under any project. With above, GTD flow can be followed completely.

### My contributions 

#### Code contributed 
Kindly follow [this link](https://nus-tic4001-ay2122s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-17&tabOpen=true&tabType=authorship&tabAuthor=l-shihao&tabRepo=AY2122S1-TIC4001-F18-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false) to the tp Code Dashboard.

#### Enhancements implemented 
The two big chunks of my code are not features, but 2 major underlying data structures - `GtdThought` and `GtdList` which provide infrastructures / methods for facilities / commands to interact, call and build upon.

The noble feature I built is called `proj-mode`, which is a command that enters a mode to simplify a complex action, put tasks from Inbox to be under one of all projects. Generally, one would think for command line interface to arrange among 2 lists, first need to print list 1 and select items, then print list 2 and select item to perform the action. To avoid vertically print 2 lists one after another which may involve user scrolling back and forth, `proj-mode` prints 2 lists side by side, with such 2-column view, user can use `->` command to transfer items from left list to right list.

Various bugs fixing among different places.

#### Contributions to User Guide
- UG draft


#### Contributions to Developer Guide
Documented sections:
- target user profile
- product value proposition
- user persona
- user stories
- non-function requirements
- glossary
- instructions for manual testing

#### Contributions to team-based tasks
+ set up team organization 
+ my role is to keep track and wipe on the completion of [issues](https://github.com/AY2122S1-TIC4001-F18-3/tp/issues?q=is%3Aissue+is%3Aclosed)
+ when team member unable to deliver PR of assigned issues on time, will intervene in order not to miss the deadline
+ first time set up CI all green, including initial fix of all `checkstyle` with ruiting and `text-ui-test`, maintain all green afterwards
+ perform demo of the product, quick fix of the bugs that show up during the rehearsal of the demonstration
+ release major version `v1.0`, `v1.4`, `v2.0`
+ arrange more than half of the meetings
+ majority of the writing on [google docs](https://docs.google.com/document/d/1VIJ82_uYj_6vg6yAU3R6hSfGvMCJIGGmnv1DLWzPNLA/edit?usp=sharing) shared document, including meeting minutes and action deliverables


#### Review