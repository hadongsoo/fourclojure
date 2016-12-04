(ns fourclojure.core)

;#49 split a sequence

(split-at 2 '(1 2 3 4 5))

(#(split-at %1 %2) 3 [1 2 3 4 5 6])
(nth [1 2 3 4 5 6] 3)

((fn test [pred coll]
   (fn test2 [pred coll]
     (list pred coll)
;;      (nth coll pred)
     )
;;    (split-with
;;      (fn (nth coll pred))
;;      coll))
   )
3 '(1 2 3 4 5))

((fn [pred coll]
  (fn [pred coll]
    (list pred coll)
    ))
3 '(1 2 3 4 5))


;; (fn newsplit [pred coll]
;;      (split-with fn(nth coll pred) coll))
;;   3 [1 2 3 4 5])

(split-with fn(nth [1 2 3 4 5] 3) [1 2 3 4 5])

; split-with 를 활용해서 중간에 함수를 넣어서 작동하게 하고 싶었으나, 함수 안 함수 개념에서 막힘



