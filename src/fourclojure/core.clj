(ns fourclojure.core)

(defn gugu [numb]
  (let [n (range numb 10)
        nr (range 1 10)]
        (map #(* (first n) %) nr)))

(gugu 2)

(map gugu (range 2 10))
