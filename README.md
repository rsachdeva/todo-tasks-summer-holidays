# todo-tasks-summer-holidays

Command line app to build entered todo lists for summer tasks in Clojure.

## Usage
Sample run:

> lein run

atom-swap-version
Welcome to task listing for summer holidays!
Number of tasks?
3
Task code?
1
Task description?
1
Task days given to complete?
1
tasks uptil now {"1" {"task-description" "1", "task-days-given-to-complete" "1"}}
Task code?
2
Task description?
2
Task days given to complete?
2
tasks uptil now {"1" {"task-description" "1", "task-days-given-to-complete" "1"}, "2" {"task-description" "2", "task-days-given-to-complete" "2"}}
Task code?
3
Task description?
3
Task days given to complete?
3
tasks uptil now {"1" {"task-description" "1", "task-days-given-to-complete" "1"}, "2" {"task-description" "2", "task-days-given-to-complete" "2"}, "3" {"task-description" "3", "task-days-given-to-complete" "3"}}
loop-recur-version
Number of tasks?
2
tasks uptil now in immutable way{}
Task code?
1
Task description?
1
Task days given to complete?
1
tasks uptil now in immutable way{"1" {"task-description" "1", "task-days-given-to-complete" "1"}}
Task code?
2
Task description?
2
Task days given to complete?
2
final tasks uptil now in immutable way {"2" {"task-description" "2", "task-days-given-to-complete" "2"}, "1" {"task-description" "1", "task-days-given-to-complete" "1"}}
map-reduce-version
Number of tasks?
3
Task code?
3
Task description?
3
Task days given to complete?
3
Task code?
4
Task description?
4
Task days given to complete?
4
Task code?
6
Task description?
6
Task days given to complete?
6
{"6" {"task-description" "6", "task-days-given-to-complete" "6"}, "4" {"task-description" "4", "task-days-given-to-complete" "4"}, "3" {"task-description" "3", "task-days-given-to-complete" "3"}}

## License

Copyright © 2013 Rohit Sachdeva, DRInnovations, LLC (www.drinnovations.us)

Distributed under the Eclipse Public License, the same as Clojure.
