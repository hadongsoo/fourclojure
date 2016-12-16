(ns fourclojure.core)

;; #27 Palindrome Detector

;; (false? (__ '(1 2 3 4 5)))
;; (true? (__ "racecar"))
;; (true? (__ [:foo :bar :foo]))
;; (true? (__ '(1 1 3 3 1 1)))
;; (false? (__ '(:a :b :c)))


(#(= (map str (reverse %)) (map str %)) "racecar")
(#(list (seq (reverse %)) (seq %)) "racecar")

;; str로 바꾸는 것은 오류가 있음
;; 기존에 seq가 훨씬 나음
