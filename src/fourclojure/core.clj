(ns fourclojure.core)


(doseq [x [1 2 3 4 5]]
  (list x))

(doseq [x [1 2 3 4 5 6]
        y [2 3]]
  (* x y))

(conj [] '(1 2 3))
