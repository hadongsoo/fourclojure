(ns fourclojure.core)

;; #42 factorial

;; (= (__ 1) 1)
;; (= (__ 3) 6)
;; (= (__ 5) 120)
;; (= (__ 8) 40320)


(#(apply * (range 1 (inc %))) 8)


((fn [val1]
   (reduce * (range 1 (inc val1)))) 8)



;; factorial이 더하긴줄 알았다. 문제를 정확히 파악하는 것도 중요.
