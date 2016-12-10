(ns fourclojure.core)

;; #145 for


(for [x (range 40) :when (= 1 (rem x 4))]
  x)


(for [x (iterate #(+ 4 %) 0)
      :let [z (inc x)]
      :while (< z 40)]
  z)

(for [[x y] (partition 2 (range 20))]
  (list x y))

;; for는 그냥 많이 써봐야 할듯 let, while도 그렇고
