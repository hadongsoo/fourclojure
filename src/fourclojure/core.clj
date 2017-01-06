(ns fourclojure.core)

(defn sum-f [f1 f2 data]
  (+ (f1 data) (f2 data)))

(sum-f inc dec 4) ;=> 8
(sum-f inc identity 5) ;=> 11
(sum-f identity - 10) ;=> 0

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(filter (less-than 3) [1 2 3 4 5])   ;=> (1 2)
(filter (less-than 4) [-2 12 3 4 0]) ;=> (-2 3 0)
(filter (equal-to 2) [2 1 3 2.0])    ;=> (2 2.0)
(filter (equal-to 2) [3 4 5 6])      ;=> ()

(def graphic-novels [{:name "Yotsuba 1" :series "Yotsuba"}
                     {:name "Yotsuba 5" :series "Yotsuba"}
                     {:name "Persepolis"}
                     {:name "That Yellow Bastard" :series "Sin City"}
                     {:name "The Hard Goodbye" :series "Sin City"}
                     {:name "Maus"}
                     {:name "Solanin"}
                     {:name "Monster 3" :series "Monster"}])

(filter :series graphic-novels)

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(filter (key->predicate "name") [{"name" "dongsoo"}{"test" "no"}{"name" "ha"}])

(defn set->predicate [a-key]
  (fn [a-map]
    (or (a-key a-map)(= nil a-map))))

(filter (set->predicate #{1 2 3})     [0 2 4 6])       ;=> (2)
(filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6]) ;=> (2 nil nil)

(defn pred-and [fn1 fn2]
  (fn [a-map]
    (and (fn1 a-map) (fn2 a-map))
    ))

(filter (pred-and pos? even?) [1 2 -4 0 6 7 -3]) ;=> [2 6]
(filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) ;=> [1 7]
(filter (pred-and (complement nil?) empty?) [[] '() nil {} #{}]);=> [[] '() {} #{}]

(defn pred-or [fn1 fn2]
  (fn [a-map]
    (or (fn1 a-map)(fn2 a-map))))

(filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])  ;=> [1 2 6 7 -3]
(filter (pred-or pos? even?) [1 2 -4 0 6 7 -3]) ;=> [1 2 -4 0 6 7]

(defn whitespace? [character]
  (Character/isWhitespace character))

(whitespace? ["a"])

(defn blank? [string]
  (map empty? (seq string)))
;;   (map string? string))


(blank? " \t\n\t ") ;=> true
(blank? "  \t a")   ;=> false
(blank? "")         ;=> true
