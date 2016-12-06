(ns fourclojure.core)

;#51 Advanced destructure


;; [a b & c :as d]

(range 1 6)

[1 2 [3 4 5] [1 2 3 4 5]]

(let [[a b & c :as e] [1 2 3 4 5 6 7]]
  [a b c e])


(let [{a :a, b :b, c :c, :as m :or {a 2 b 3}}  {:a 5}]
  [a b c m])

; destructure 구조를 알게 하려는 예제,
; 1~5까지 let 화 시키면 (let [[a b & c :as e] [1 2 3 4 5]] [a b c d e])

(let [[a b & c :as d] [1 2 3 4 5]] [a b c d])




(let [[a b c d e :as home] [0 1 2 3 4]] home)

(let [[a b c d e :or home] [0 1 2 3 4]]
  home)
