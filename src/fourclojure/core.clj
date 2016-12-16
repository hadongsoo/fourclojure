(ns fourclojure.core)

;; #24 sum it all up
(#(apply + %) (list 0 -2 5 5))

;; #25 Find the odd numbers

(#(filter odd? %)
 #{1 2 3 4 5})

;; #23 Reverse a Sequence

(#(reduce conj () %) [1 2 3 4 5])

(sorted-set 5 7 2 7)

(reduce conj [] [1 2 3 4 5])
(reduce #(* %1 %2) [1 2 3 4 5])

;;reduce는 두가지 값을 필요로하는 함수가 필요하다.
;; (reduce foo [1 2 3 4]) > (foo (foo (foo 1 2) 3) 4)
;; (apply foo [1 2 3 4]) > (foo 1 2 3 4) > foo 가 여러 인자를 받음


(conj () [3 4])

(next [1 2 3 4 5])


((fn ^:static lasttest [s]
        (if (next s)
          (recur (next s))
          (first s)))
[1 2 3 4 5])

;; recur 에 대한 이해가 더 필요하다. 재귀인 것은 이해하나, 활용하기가 어렵다.

(take 5 (iterate #(* 2 %) 5))

;; iterate가 살짝 이해되려고 한다. 인자 함수에 넣고 다시 그 결과를 함수에 넣는다.
