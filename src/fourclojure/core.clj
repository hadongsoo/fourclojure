(ns fourclojure.core)

;; #30 compress a Sequence

;; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

(apply str (map first (partition-by identity "Leeeeeerrroyyy")))

#(map first (partition-by identity %))

;; contains?

(contains? [1 2 3 4 5] 1)

(contains? [:a :b :c :d] :a)
(contains? [:a :b :c :d] 1)
(contains? [:a :b :c :d] 0)
