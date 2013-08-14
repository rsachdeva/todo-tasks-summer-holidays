(ns todo-tasks-summer-holidays.core)

(defn todo-prompt [question]
  (println question)
  (read-line))

;mutable with atom and swap!

(def todos (atom {}))

(defn todo-details [todos]
  (let [task-code (todo-prompt "Task code?")
        task-description (todo-prompt "Task description?")
        task-days-given-to-complete (todo-prompt "Task days given to complete?")]
    (swap! todos into {task-code {"task-description" task-description
                                  "task-days-given-to-complete" task-days-given-to-complete}})))

(defn atom-swap-version []
  (println "Welcome to task listing for summer holidays!")
  (dotimes [n (read-string (todo-prompt "Number of tasks?"))]
    (todo-details todos)
    (println (str "tasks uptil now " @todos))))


;immutable with loop and recur

(defn immutable-todo-details []
  (let [task-code (todo-prompt "Task code?")
        task-description (todo-prompt "Task description?")
        task-days-given-to-complete (todo-prompt "Task days given to complete?")]
    {task-code {"task-description" task-description
                "task-days-given-to-complete" task-days-given-to-complete} }))

(defn loop-recur-version []
  (loop [n (read-string (todo-prompt "Number of tasks?"))
         tasks {}]
    (if (< n 1)
      (println (str "final tasks uptil now in immutable way " tasks))
      (do
        (println (str "tasks uptil now in immutable way" tasks))
        (recur (- n 1)
          (conj tasks (immutable-todo-details)))))))

;immutable with higher order functions

(defn todo-task-details []
  (let [task-code (todo-prompt "Task code?")
        task-description (todo-prompt "Task description?")
        task-days-given-to-complete (todo-prompt "Task days given to complete?")]
    {task-code {"task-description" task-description
                "task-days-given-to-complete" task-days-given-to-complete} }))

(defn accumulate-all-tasks-from-prompt []
  (doall (repeatedly (. Integer parseInt  (todo-prompt "Number of tasks?")) todo-task-details)))

(defn -main []
  (println "atom-swap-version")
  (atom-swap-version)
  (println "loop-recur-version")
  (loop-recur-version)
  (println "higer-order-functions-version")
  (accumulate-all-tasks-from-prompt))
