(ns fourclojure.core)

(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))

(factorial 14)

(defn power [n k]
  (cond
    (= 0 k) 1
;;     (= 1 k) n
    :else (* n (power n (dec k)))))

;; 5 3
;; (power 5 3)
;; (* 5 (power 5 2))
;; (* 5 (* 5 (power 5 1)))
;; (* 5 (* 5 (* 5 (power 5 0))))
;; (* 5 (* 5 (* 5 1)))


(power 2 1)
(power 2 2)  ;=> 4
(power 5 3)  ;=> 125
(power 7 0)  ;=> 1
(power 0 10) ;=> 0

;; 간단한 재귀도 아직 이해가 잘 안된다.
;; 머리로 그림이 그려지질 않는데, 다 풀어서 작성해보면 좀 이해가 된다. 아직 어려움


(defn ftest [n]
  (if (< n 3)
    n
    (+      (ftest (- n 1))
       (* 2 (ftest (- n 2)))
       (* 3 (ftest (- n 3))))))

(ftest 5)

;; make fib use recur


(defn fib [n]
  (cond
    (= 0 n) 0
    (= 1 n) 1
    :else (+ (fib (- n 1)) (fib (- n 2)))))

(fib 0) ;=> 0
(fib 1) ;=> 1
(fib 2) ;=> 1
(fib 3) ;=> 2
(fib 4) ;=> 3
(fib 5) ;=> 5
(fib 6) ;=> 8
...
(fib 10) ;=> 55
(fib 20)

(defn my-repeat [n index]
;;   (if (> 0 n)
;;     '()
    (repeat n index))

(my-repeat 2 :a)    ;=> (:a :a)
(my-repeat 3 "lol") ;=> ("lol" "lol" "lol")
(my-repeat -1 :a)   ;=> ()

(defn my-range [n]
  (if (>= 0 n)
    '()
    (reverse (range 0 n))))


(my-range 0)  ;=> ()
(my-range 1)  ;=> (0)
(my-range 2)  ;=> (1 0)
(my-range 3)  ;=> (2 1 0)


(defn tails [index]
  (if (= 0 (count index))
    '(())
    (cons (seq index) (tails (rest index)))))

(defn inits [index]
  (if (= 0 (count index))
    '(())
    (cons (seq index)
          (inits (take (dec (count index)) index)))))

;; other guys answer

;; (defn inits [a-seq]
;;   (if (empty? a-seq)
;;     (cons '() '())
;;     (map reverse (tails (reverse a-seq)))))


(tails [1 2 3 4]) ;=> ((1 2 3 4) (2 3 4) (3 4) (4) ())
(inits [1 2 3 4]) ;=> (() (1) (1 2) (1 2 3) (1 2 3 4))
(inits [1 2 3 4]) ;=> ((1 2) () (1 2 3) (1) (1 2 3 4))

(reverse [1 2 3]) ;=> (3 2 1)
(reverse [2 3 1]) ;=> (1 3 2)



(concat "abc" "def")
(cons "abc" "def")
(concat [:a :b :c][1 2 3])
(cons [:a :b :c][1 2 3])

;; concat 은 모든 인자를 풀어서 list화 한다
;; cons는 두번째 인자부터 하나씩 인자를 받는다.

(defn rotations* [index]
  (take (count index)
        (partition (count index) 1 (cycle index))))

;; 4clojure 했던 내용대로 파티션으로 해결
;; 다른 해답

(defn rotations [a-seq]
  (if (empty? a-seq)
     (cons '() '())
     (rest (map concat (reverse (tails a-seq)) (inits a-seq)))))

(rotations [])        ;=> (())
(rotations [1 2 3])   ;=> ((1 2 3) (2 3 1) (3 1 2))
(rotations [:a :b])   ;=> ((:a :b) (:b :a))

(rotations [:a :b])   ;=> ((:b :a) (:a :b))
(rotations [1 5 9 2]) ;=> ((1 5 9 2) (2 1 5 9) (9 2 1 5) (5 9 2 1))


(count (rotations [6 5 8 9 2])) ;=> 5

(concat [1 2 3] [:a :b :c]) ;=> (1 2 3 :a :b :c)
(concat [1 2] [3 4 5 6])    ;=> (1 2 3 4 5 6)
