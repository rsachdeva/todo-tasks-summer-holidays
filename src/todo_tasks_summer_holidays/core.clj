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

;immutable with map and reduce

(defn for-map-todo-details [x]
  (let [task-code (todo-prompt "Task code?")
        task-description (todo-prompt "Task description?")
        task-days-given-to-complete (todo-prompt "Task days given to complete?")]
    {task-code {"task-description" task-description
                "task-days-given-to-complete" task-days-given-to-complete} }))

(defn map-reduce-version []
  (reduce conj (map for-map-todo-details (range (read-string (todo-prompt "Number of tasks?"))))))

(defn -main []
  (println "atom-swap-version")
  (atom-swap-version)
  (println "loop-recur-version")
  (loop-recur-version)
  (println "map-reduce-version")
  (map-reduce-version))
