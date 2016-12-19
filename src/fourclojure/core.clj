(ns fourclojure.core)

(some #(if (odd? %) %) [1 2 3 4 5])
(#(if (odd? %) %) 1)

;; some은 앞에 리스트로 뒤에 리스트에 하나라도 포함되면 바로 출력한다.
