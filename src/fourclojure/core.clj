(ns fourclojure.core)

(defn prime? [numb]
  (empty? (filter #(= 0 (mod numb %)) (range 2 numb))))

(prime? 4) ;=> false
(prime? 7) ;=> true
(prime? 10) ;=> false
(filter prime? (range 2 50)) ;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)


(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll) (product (rest coll)))))

(product [])        ;=> 1  ; special case
(product [1 2 3])   ;=> 6
(product [1 2 3 4]) ;=> 24
(product [0 1 2])   ;=> 0
(product #{2 3 4})  ;=> 24 ; works for sets too!

(defn singleton? [coll]
  (if (and (first coll)(empty? (rest coll)))
    true
    false))

(singleton? [1])     ;=> true
(singleton? #{2})    ;=> true
(singleton? [])      ;=> false
(singleton? [1 2 3]) ;=> false

(defn my-last [coll]
  (if (empty? (rest coll))
    (first coll)
    (my-last (rest coll))))

(my-last [])      ;=> nil
(my-last [1 2 3]) ;=> 3
(my-last [2 5])   ;=> 5

(defn max-element [coll]
  (if (empty? (rest coll))
    (first coll)
    (max (first coll) (max-element (rest coll)))))

(max-element [2 4 1 4]) ;=> 4
(max-element [2])       ;=> 2
(max-element [])        ;=> nil

(defn seq-max [coll coll2]
  (if (> (count coll) (count coll2))
    coll
    coll2))

(seq-max [1] [1 2])   ;=> [1 2]
(seq-max [1 2] [3 4]) ;=> [3 4]

(defn longest-sequence [coll]
  (if (empty? (rest coll))
    (first coll)
    (seq-max (first coll) (longest-sequence (rest coll)))))

(longest-sequence [[1 2] [] [1 2 3]]) ;=> [1 2 3]
(longest-sequence [[1 2] [1 2 3 4 5] [1 2 3]]) ;=> [1 2 3]
(longest-sequence [[1 2]])            ;=> [1 2]
(longest-sequence [])                 ;=> nil

(defn my-filter [f a-seq]
  (if (empty? a-seq)
    a-seq
    (if (f (first a-seq))
      (cons (first a-seq) (my-filter f (rest a-seq)))
      (my-filter f (rest a-seq)))))

(my-filter odd? [1 2 3 4]) ;=> (1 3)
(my-filter (fn [x] (> x 9000)) [12 49 90 9001]) ;=> (9001)
(my-filter even? [1 3 5 7]) ;=> ()

(defn sequence-contains? [ky coll]
  (if (empty? coll)
    false
    (if (= ky (first coll))
      true
      (sequence-contains? ky (rest coll)))))

(sequence-contains? 3 [1 2 3]) ;=> true
(sequence-contains? 3 [4 7 9]) ;=> false
(sequence-contains? :pony [])  ;=> false

;; 재귀가 정확하게 이해되진 않으나,
;; 리스트내 1번째 값의 동작 + 나머지 값을 다시 함수에 입력 한다는 개념으로 이해하기 시작

