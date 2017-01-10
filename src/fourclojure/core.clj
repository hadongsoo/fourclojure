(ns fourclojure.core)

(defn prime? [numb]
  (empty? (filter #(= 0 (mod numb %)) (range 2 numb))))

(prime? 4) ;=> false
(prime? 7) ;=> true
(prime? 10) ;=> false
(filter prime? (range 2 50)) ;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)

