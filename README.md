# WY Space exercise

Approach 1: Visit each time and test the satellites that intersect the given time within its interval of communication, which requires O(n*m). Where n is the number of time intervals during a day, and m is the number of satellites. 

Approach 2: Interval Tree data strcuture.

## Introduction

In the folder doc, you will find a word document that specifics in more detail all the processes that I follow to solve the problem. 

Thank you. I enjoy the problem!

## Installation

Install Java 8 or superior

Clone the git repository:

git clone https://github.com/cguz/Interview_VEGA.git .


## How to use


Execute the application

java -jar wySpace.jar PASS_SCHEDULE_FILE MAX_BANDWIDTH


For instance:

java -jar wySpace.jar input/2458843pass-schedule.txt 40


By the default the application is executed with the second approach. To execute it with the approach 1, please do it as follow:

java -jar wySpace.jar input/2458843pass-schedule.txt 40 approach1


## Known Bugs

[ ] Does not consider as end times "23:30" and "00:00"

