# Project 1 - *Todo List*

**Todo List** is an android app that allows building a todo list and basic todo items management functionality including adding new items and deleting an existing item.

Submitted by: **Colby Killian**

Time spent: **4** hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **view a list of todo items**
* [X] User can **successfully add and remove items** from the todo list
* [X] User's **list of items persisted** upon modification and and retrieved properly on app restart

The following **optional** features are implemented:

* [ ] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list (Coming soon!)

The following **additional** features are implemented:

* [ ] (Additional features coming soon!)

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://i.imgur.com/WLJc9cN.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [ShareX](https://getsharex.com/).

## Notes

When trying to implement the delete function, application would crash uppon long clicking. This was beacuse a new instance of **taskAdapter** was declared as **final**. This was fixed and the delete function works as intended. 

## License

    Copyright [2022] [Colby Killian]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
