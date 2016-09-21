(ns fourclojure.core)

;;26 fibonacci sequence

(#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 3)

(#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 4)

((defn fibo* [[a b]]
  [b (+ a b)]
   )[1 1])

(fibo* [1 3])

(#(take 5 (map first (iterate fibo* [1 1]))))


;;27 Palindrome Detector
;;seq make any Collection > seq

(reverse seq '(1 2 3 4 5))

(seq '(1 2 3 4 5))

(seq [1 2 3 [3 4] 4])

(seq "hahahahah")

(defn palindrome [x]
  ;;(list (= x (reverse x)))
  (= (seq x) (reverse (seq x)))
  )

(palindrome '(1 2 1))
(palindrome "racecar")
(palindrome "rre")

;; shorter
(#(= (seq %) (reverse (seq %))) '(1 2 1))
(#(= (seq %) (reverse (seq %))) "helleh")

;;28 flatten > pass

;;29 get the caps
(require 'clojure.string)
(#(clojure.string/capitalize %) "HeLlO, WoRlD!")

(#(re-seq #"[A-Z]" %) "HeLlO, WoRlD!")

(#(apply str (re-seq #"[A-Z]" %)) "HeLlO, WoRlD!")

