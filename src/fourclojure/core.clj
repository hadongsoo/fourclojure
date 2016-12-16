(ns fourclojure.core)

;; #26 Fibonacci Sequence

;; (= (__ 3) '(1 1 2))
;; (= (__ 6) '(1 1 2 3 5 8))
;; (= (__ 8) '(1 1 2 3 5 8 13 21))

(#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 6)

;; 피보나치는 아직도 헷갈린다. iterate는 (함수 (함수 (함수 인자))) 인걸 좀 이해했지만 아직 헷갈림
