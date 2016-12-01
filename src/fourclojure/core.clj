(ns fourclojure.core)

;;#44 Rotate Sequence


;(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
;(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
;(= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
;(= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
;(= (__ 1 '(:a :b :c)) '(:b :c :a))
;(= (__ -4 '(:a :b :c)) '(:c :a :b))


((fn rotater [n coll]
    (take (count coll) (drop (mod n (count coll)) (cycle coll))))
 -6 [0 1 2 3 4 5])


; I have to know to different 'mod' and 'rem'
(mod 2 10)

(mod 1 3)
(mod -1 3)
(mod -2 3)
(mod -3 3)
(mod -4 3)

(rem 1 3)
(rem -1 3)
(rem -2 3)
(rem -3 3)
(rem -4 3)

(rem -4 3)
(rem -1 3)
(rem -7 3)

(mod -1 3)
(rem -1 3)

