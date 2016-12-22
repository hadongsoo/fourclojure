(ns fourclojure.core)

(defn do-a-thing [x]
  (Math/pow (+ x x) (+ x x)))

(defn do-a-thing2 [x]
  (let [nor (+ x x)]
    (Math/pow nor nor)))

(do-a-thing 4)
(do-a-thing2 4)

(let [a 10 b (+ a 8)]
  (+ a b))

;; (defn spiff [coll]
;;   (nth coll 2)
;; ;;   (if (nth coll 2)
;; ;;     (+ (first coll) (nth coll 2))
;; ;;     "?"
;;     )

(defn spiff [coll]
  (if (< 2 (count coll))
    (+ (first coll) (nth coll 2))
    (println "?")
    ))

(count [1 2 3])

(spiff [1 2 3])       ;=> 4
(spiff [1 2 3 4 5 6]) ;=> 4
(spiff [1 2]) ;=> 4
(spiff [1 2])         ;=> ?
(spiff [])            ;=> ?

;; vector operation

(conj [1 2 3 4 5] 6)

(assoc [1 2 3] 1 4 2 5)

;; assoc는 맵 안에다가 몇번째, 무슨 값 형식으로 사용

(defn cutify [coll]
  (conj coll "<3"))

(cutify [])
(cutify [1 2 3])
(cutify ["a" "b"])

;; spiff 개선하기 let destructing 으로

(defn spiff2 [coll]
  (let [[a b c] coll]
    (if c
         (+ a c)
         "?")
    ))

(spiff2 [1 2 3])
(spiff2 [1 2 3 4 5 6]) ;=> 4
(spiff2 [1 2]) ;=> 4
(spiff2 [1 2])         ;=> ?
(spiff2 [])            ;=> ?


(defn rectangle [x y]
  [x y])

(rectangle [1 1] [5 1])

(defn height [x]
  (let [x1 (second (first x)) x2 (second (second x))]
    (- x2 x1))
  )

(defn width [x]
  (let [y1 (first (first x)) y2 (first (second x))]
    (- y2 y1)))

(height (rectangle [1 1] [5 1])) => 0
(height (rectangle [1 1] [5 5])) => 4
(height (rectangle [0 0] [2 3])) => 3

(width (rectangle [1 1] [5 1]))  => 4
(width (rectangle [1 1] [1 1]))  => 0
(width (rectangle [3 1] [10 4])) => 7

(defn square? [x]
  (= (height x) (width x)))

(square? (rectangle [1 1] [2 2])) ;=> true
(square? (rectangle [1 1] [2 3])) ;=> false
(square? (rectangle [1 1] [1 1])) ;=> true
(square? (rectangle [3 2] [1 0])) ;=> true
(square? (rectangle [3 2] [1 1])) ;=> false

(defn area [x]
  (* (height x) (width x)))

(area (rectangle [1 1] [5 1]))  => 0
(area (rectangle [0 0] [1 1]))  => 1
(area (rectangle [0 0] [4 3]))  => 12
(area (rectangle [3 1] [10 4])) => 21


(defn contains-point? [x y]
  (let [x1 (first (first x)) x2 (first (first (rest x))) x3 (first y)
        y1 (second (first x)) y2 (second (first (rest x))) y3 (second y)]
    (and (<= x1 x3 x2) (<= y1 y3 y2))
    ))

(defn point [x y]
  [x y])

(contains-point? (rectangle [0 0] [2 2])
                 (point 1 1))            ;=> true
(contains-point? (rectangle [0 0] [2 2])
                 (point 2 1))            ;=> true
(contains-point? (rectangle [0 0] [2 2])
                 (point -3 1))           ;=> false
(contains-point? (rectangle [0 0] [2 2])
                 (point 1 3))            ;=> false
(contains-point? (rectangle [1 1] [2 2])
                 (point 1 1))            ;=> true
(contains-point? (rectangle [1 1] [1 1])
                 (point 1 1))            ;=> true


(defn contains-rectangle? [rec1 rec2]
;;   (let [x1 (first (first rec1)) x2 x3 x4
;;         y1 y2 y3 y4]))
  (let [[[x1 y1] [x2 y2]] rec1
        [[x3 y3] [x4 y4]] rec2]
;;     (list rec1 x1 y1 x2 y2 rec2 x3 y3 x4 y4)))
  (and (<= x1 x3) (>= x2 x4) (<= y1 y3) (>= y2 y4))))

(contains-rectangle? (rectangle [0 0] [3 3])
                     (rectangle [1 1] [2 2])) ;=> true
(contains-rectangle? (rectangle [0 0] [2 2])
                     (rectangle [1 1] [3 3])) ;=> false
(contains-rectangle? (rectangle [0 0] [1 1])
                     (rectangle [0 0] [1 1])) ;=> true
(contains-rectangle? (rectangle [0 0] [1 1])
                     (rectangle [1 1] [2 2])) ;=> false
