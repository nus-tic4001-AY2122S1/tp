### Overview

NUS Mods List helps students plan their modules via a CLI interface.
The application pulls data from the NUS Mods API, and
provides users with a CLI interface to view and save modules.

### Code contributed

https://nus-tic4001-ay2122s1.github.io/tp-dashboard/?search=sohwkjames&breakdown=true&sort=groupTitle&sortWithin=title&since=2021-09-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other

### Enhancements implemented

I took charge of the Module class, getting the API calls to work,
translating json data from API into class instances,
and implemented saving/loading from persistent storage.

Getting the API calls to work was not a trivial task as it involved working with
third party package Gson. I also made sure that my implementation would work on
my team member's computers, by using Gradle and walking through Gradle build with
team members. This was important, because failing to get the API calls to work would
block the implementation of the Module class, and block the entire project.
Overall, my efforts ensured the team was not blocked.

I also improved team productivity by providing methods that would
benefit all developers, such as Module.getPrettyPrint() to return
a human readable string.

I also wrote unit tests for classes I created

### Contributions to UG

I created most of the content in the UG.

### Contributions to team based tasks

I was in charge of setting up the group repository and making sure that
all team members are able to pull and push from the repo. I did this
by asking team members to create test PRs to the repo, before starting work on the project.

I also helped team members troubleshoot problems with pushing/pulling
from the repo.

### Review/mentoring contributions

Helping team members: Pair programmed with other team members to troubleshoot bugs.
I also helped team members familiarize with the create branch -> push branch -> review PR -> merge PR 
process.

List of PRs I reviewed:

https://github.com/AY2122S1-TIC4001-F18-1/tp/pull/24

https://github.com/AY2122S1-TIC4001-F18-1/tp/pull/22

https://github.com/AY2122S1-TIC4001-F18-1/tp/pull/12

https://github.com/AY2122S1-TIC4001-F18-1/tp/pull/9

https://github.com/AY2122S1-TIC4001-F18-1/tp/pull/3