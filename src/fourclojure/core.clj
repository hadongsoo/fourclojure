(ns fourclojure.core)

;; #39 interleave make again

;; (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
;; (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
;; (= (__ [1 2 3 4] [5]) [1 5])
;; (= (__ [30 20] [25 15]) [30 25 20 15])
;; (= (__ [30 20] [25 15]) [30 25 20 15])

(#(mapcat vector %1 %2) [1 2 3] [:a :b :c])
(#(mapcat vector %1 %2) [1 2 3 4] [5])

;; 아직 map, mapcat은 많이 헷갈린다. 결과를 배열로 낸다는것,
;; vector의 기능또한 헷갈린다.

(mapcat vector [1 2] [3 4])

(map list [1 2 3 4 5] [6 7 8 9])
(mapcat list [1 2 3 4 5] [6 7 8 9])
