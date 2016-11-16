(ns fourclojure.core)


;;(= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
;;(= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
;;(= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

(#(list % %2) [1 2 3 4 5 6] 2)

(defn for-test [index numb]
;;   (for [x index y (count index)] [x y])
  (for [i (range numb)] [i index])
  )

(for-test [1 2 3 4 5 6 7] 2)

((fn deinterleave [coll n]
  (for [i (range n)]
    (take-nth n (drop i coll))
;;       (drop i coll)
    ))
 [1 2 3 4 5 6 7] 3)

(#(for [i (range %2)](take-nth %2 (drop i %))) [1 2 3 4 5 6] 2)
