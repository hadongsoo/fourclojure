(ns fourclojure.core)

;; #161 subset, superset

(clojure.set/superset? #{1} #{2})

(clojure.set/subset? #{1} #{1 2})
(clojure.set/superset? #{1 2} #{2})

;; 부분집합 그리고 확대?집합인듯 개념은 어렵지 않다.
