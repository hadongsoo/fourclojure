(ns fourclojure.core)

;; #34 Implement range

;; (= (__ 1 4) '(1 2 3))
;; (= (__ -2 2) '(-2 -1 0 1))
;; (= (__ 5 8) '(5 6 7))

(range 1 4)

(#(take (- %2 %1) (iterate inc %1)) 5 8)
(#(take (- %2 %1) (iterate inc %1)) -2 2)
(#(take (- %2 %1) (iterate inc %1)) 1 4)

;; 기존에도 동일한 방법을 생각해냈다.
