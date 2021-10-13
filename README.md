# Project NEXT

This is a task management app that follows the GTD method for GTD enthusiasts who prefer the speed of command line input. 
``` 
_   _           _   
| \ | | _____  _| |_ 
|  \| |/ _ \ \/ / __|
| |\  |  __/>  <| |_ 
|_| \_|\___/_/\_\\__|
```

## General Skeleton for how the Project is structured.

There are 2 main concepts for the project.
1) We will have **_commands_** as per the following.

| CRUD          | Command                                                             |
|---------------|---------------------------------------------------------------------|
| CREATE        | add TASK_NAME                                                       |
| READ          | list inbox<br>list next  <br>list wait<br>list proj<br>list someday |
| UPDATE (Move) | move INDEX... -f=FOLDER                                             |
| UPDATE (Done) | done INDEX...                                                       |
| DELETE        | delete INDEX...                                                     |

2) we will also track the current project context of the user.  
So that the commands run will update their workspace accordingly.


## How to use 

## Build automation using Gradle

* This project uses Gradle for build automation and dependency management. It includes a basic build script as well (
  i.e. the `build.gradle` file).
* If you are new to Gradle, refer to
  the [Gradle Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/gradle.html).


## Testing

### I/O redirection tests

* To run _I/O redirection_ tests (aka _Text UI tests_), navigate to the `text-ui-test` and run the `runtest(.bat/.sh)`
  script.

### JUnit tests

* A skeleton JUnit test (`src/test/java/seedu/duke/DukeTest.java`) is provided with this project template.
* If you are new to JUnit, refer to
  the [JUnit Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/junit.html).

## Checkstyle

* A sample CheckStyle rule configuration is provided in this project.
* If you are new to Checkstyle, refer to
  the [Checkstyle Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/checkstyle.html).

## CI using GitHub Actions

The project uses [GitHub actions](https://github.com/features/actions) for CI. When you push a commit to this repo or PR
against it, GitHub actions will run automatically to build and verify the code as updated by the commit/PR.

## Documentation

`/docs` folder contains a skeleton version of the thought documentation.

Steps for publishing documentation to the public:

1. If you are using this project template for an individual project, go your fork on GitHub.
1. Click on the `settings` tab.
1. Scroll down to the `GitHub Pages` section.
1. Set the `source` as `master branch /docs folder`.
1. Optionally, use the `choose a theme` button to choose a theme for your documentation.
