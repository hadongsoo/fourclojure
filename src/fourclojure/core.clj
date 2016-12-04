(ns fourclojure.core)

;#47
;(contains? #{4 5 6} __)
;(contains? [1 1 1 1 1] __)
;(contains? {4 :a 2 :b} __)
;(not (contains? [1 2 4] __))

(contains? #{4 5 6} 4)
(contains? [1 1 1 1 1] 4)
(not (contains? [1 1 1 1 4] 4))
(contains? [1 1 1 1 1] 1)
(not (contains? [1 1 1 1 4] 2))

(contains? [1 2 4] 0)

; contains은 맵/해쉬맵 등에만 작동되고, 배열에는 배열 갯수와 관련해서 작동하는 듯 하다.
