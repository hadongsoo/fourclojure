(ns fourclojure.core)


(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))

(factorial 14)

(defn power [n k]
  (cond
    (= 0 k) 1
;;     (= 1 k) n
    :else (* n (power n (dec k)))))

;; 5 3
;; (power 5 3)
;; (* 5 (power 5 2))
;; (* 5 (* 5 (power 5 1)))
;; (* 5 (* 5 (* 5 (power 5 0))))
;; (* 5 (* 5 (* 5 1)))


(power 2 1)
(power 2 2)  ;=> 4
(power 5 3)  ;=> 125
(power 7 0)  ;=> 1
(power 0 10) ;=> 0

;; 간단한 재귀도 아직 이해가 잘 안된다.
;; 머리로 그림이 그려지질 않는데, 다 풀어서 작성해보면 좀 이해가 된다. 아직 어려움
