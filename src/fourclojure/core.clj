(ns fourclojure.core)

(defn suit [trumpcde]
  (let [[_ valsecond] trumpcde]
    (str valsecond)))

(suit "2H") ;=> "H"
(suit "2D") ;=> "D"
(suit "2C") ;=> "C"
(suit "3S") ;=> "S"

(defn rank [trumpcode]
  (let [[valfirst _] trumpcode
        repl {\T 10 \J 11 \Q 12 \K 13 \A 14 }]
    (if (get repl valfirst)
      (get repl valfirst)
      (read-string (str valfirst)))))


(rank "2H") ;=> 2
(rank "4S") ;=> 4
(rank "TS") ;=> 10
(rank "JS") ;=> 11
(rank "QS") ;=> 12
(rank "KS") ;=> 13
(rank "AS") ;=> 14

(frequencies [4 7 7 4 7]) ;=> {4 2, 7 3}

(vals (frequencies [4 7 7 4 7]))
;=> (2 3)
;   ^-- now that looks a lot like a full house

(max 1 5 4 2) ;=> 5
(min 1 5 4 2) ;=> 1


(def high-seven ["2H" "3S" "4C" "5C" "7D"])

(def high-seven                   ["2H" "3S" "4C" "5C" "7D"])
(def pair-hand                    ["2H" "2S" "4C" "5C" "7D"])
(def two-pairs-hand               ["2H" "2S" "4C" "4D" "7D"])
(def three-of-a-kind-hand         ["2H" "2S" "2C" "4D" "7D"])
(def four-of-a-kind-hand          ["2H" "2S" "2C" "2D" "7D"])
(def straight-hand                ["2H" "3S" "6C" "5D" "4D"])
(def low-ace-straight-hand        ["2H" "3S" "4C" "5D" "AD"])
(def high-ace-straight-hand       ["TH" "AS" "QC" "KD" "JD"])
(def flush-hand                   ["2H" "4H" "5H" "9H" "7H"])
(def full-house-hand              ["2H" "5D" "2D" "2C" "5S"])
(def straight-flush-hand          ["2H" "3H" "6H" "5H" "4H"])
(def low-ace-straight-flush-hand  ["2D" "3D" "4D" "5D" "AD"])
(def high-ace-straight-flush-hand ["TS" "AS" "QS" "KS" "JS"])

(defn contains-duplicates? [coll]
  (if-not (= (count (set coll))(count coll)) true false))

(contains-duplicates? [1 1 2 3 -40]) ;=> true
(contains-duplicates? [1 2 3 -40]) ;=> false
(contains-duplicates? [1 2 3 "a" "a"]) ;=> true

(defn pairchecker [coll]
  (reverse (sort (vals (frequencies (map rank coll))))))

(pairchecker pair-hand)
(pairchecker two-pairs-hand)
(pairchecker high-seven)


(defn pair? [collname]
  (let [pair-data '(2 1 1 1)
        isit (fn [coll] (if (= coll pair-data) true false))]
  (isit (pairchecker (map rank collname)))))

(defn three-of-a-kind? [collname]
  (let [pair-data '(3 1 1)
        isit (fn [coll] (if (= coll pair-data) true false))]
  (isit (pairchecker (map rank collname)))))

;; (three-of-a-kind? two-pairs-hand)       ;=> false
;; (three-of-a-kind? three-of-a-kind-hand) ;=> true

(defn four-of-a-kind? [collname]
  (let [pair-data '(4 1)
        isit (fn [coll] (if (= coll pair-data) true false))]
  (isit (pairchecker (map rank collname)))))



(four-of-a-kind? two-pairs-hand)      ;=> false
(four-of-a-kind? four-of-a-kind-hand) ;=> true

(defn flush? [collname]
  (if (= 1 (count (set (map suit collname)))) true false))

(flush? pair-hand)  ;=> false
(flush? flush-hand) ;=> true)


(defn full-house? [collname]
  (let [pair-data '(3 2)
        isit (fn [coll] (if (= coll pair-data) true false))]
  (isit (pairchecker (map rank collname)))))

(full-house? three-of-a-kind-hand) ;=> false
(full-house? full-house-hand)      ;=> true

(defn two-pairs? [collname]
  (let [pair-data ['(2 2 1) '(4 1)]
        isit (fn [coll] (if (or (= coll (first pair-data))(= coll (second pair-data))) true false))]
  (isit (pairchecker (map rank collname)))))


(two-pairs? two-pairs-hand)      ;=> true
(two-pairs? pair-hand)           ;=> false
(two-pairs? four-of-a-kind-hand) ;=> true


(defn straight? [coll]
  (let [colldata (sort (map rank coll))
        mindata (apply min colldata)
        maxdata (inc (apply max colldata))
        fullrange (range mindata maxdata)]
    (if (or (= colldata fullrange)
            (= colldata '(2 3 4 5 14)))
      true
      false)))

(straight? two-pairs-hand)             ;=> false
(straight? straight-hand)              ;=> true
(straight? low-ace-straight-hand)      ;=> true
(straight? ["2H" "2D" "3H" "4H" "5H"]) ;=> false
(straight? high-ace-straight-hand)     ;=> true

(defn straight-flush? [coll]
  (and (straight? coll) (flush? coll)))

(straight-flush? straight-hand)                ;=> false
(straight-flush? flush-hand)                   ;=> false
(straight-flush? straight-flush-hand)          ;=> true
(straight-flush? low-ace-straight-flush-hand)  ;=> true
(straight-flush? high-ace-straight-flush-hand) ;=> true

(defn high-card? [hand]
  true) ; All hands have a high card.

(defn value [coll]
  (let [checkers #{[high-card? 0]  [pair? 1]
                 [two-pairs? 2]  [three-of-a-kind? 3]
                 [straight? 4]   [flush? 5]
                 [full-house? 6] [four-of-a-kind? 7]
                 [straight-flush? 8]}
        funcs [map first checkers]
        firstfuncs (second funcs)]
;;     ((fn [funcsdata coll] (list funcsdata coll))
;;     firstfuncs coll)
;;     (list flush? "hello" firstfuncs)
;;         (nth funcs 2)
;;     (first (last funcs))
      (type straight?)
      (type (first checkers))
      (last funcs)

    ))


(def minifunc (map first #{[straight? 1] [two-pairs? 4]}))
(type minifunc)

;; (map (fn [mif]
;; ;;        (apply mif pair-hand))
;; ;;        (apply mif pair-hand))
;; ;;        (mif pair-hand))
;; ;;        (list `mif "/" two-pairs?)
;;      (`mif two-pairs-hand))
;;      minifunc)

(two-pairs? two-pairs-hand)

(value high-seven)           ;=> 0
(value pair-hand)            ;=> 1
(value two-pairs-hand)       ;=> 2
(value three-of-a-kind-hand) ;=> 3
(value straight-hand)        ;=> 4
(value flush-hand)           ;=> 5
(value full-house-hand)      ;=> 6
(value four-of-a-kind-hand)  ;=> 7
(value straight-flush-hand)  ;=> 8
