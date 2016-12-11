(ns fourclojure.core)

;; #156 map default

(#(apply hash-map (interleave %2 (repeat %1)))
0 [:a :b :c])

((fn [va coll]
   (map #(list % va) coll))
0 [:a :b :c])

;; interleave와 repeat 눈치로만 알겠고, 이해가 어려움

