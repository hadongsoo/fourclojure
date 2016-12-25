(ns fourclojure.core)

(def china {:name "China Miéville", :birth-year 1972})
(def octavia {:name "Octavia E. Butler"
              :birth-year 1947
              :death-year 2006})
(def friedman {:name "Daniel Friedman" :birth-year 1944})
(def felleisen {:name "Matthias Felleisen"})

(def cities {:title "The City and the City" :authors [china]})
(def wild-seed {:title "Wild Seed", :authors [octavia]})
(def embassytown {:title "Embassytown", :authors [china]})
(def little-schemer {:title "The Little Schemer"
                     :authors [friedman, felleisen]})

(defn alive? [namek]
  (if (contains? namek :death-year) false true))

(alive? friedman)

(alive? china)   ;=> true
(alive? octavia) ;=> false


(def books [cities, wild-seed, embassytown, little-schemer])

(seq [1 2 3])          ;=> (1 2 3)
(seq {:a 42 :b "foo" :c ["ur" "dad"]})
                       ;=> ([:a 42] [:c ["ur" "dad"]] [:b "foo"])
(first (seq [1 2 3]))  ;=> 1
(rest (seq [1 2 3]))    ;=> (2 3)
(cons 0 (seq [1 2 3])) ;=> (0 1 2 3)

(seq [1 2 3])
(seq #{:a :b :c})

(defn element-lengths [coll]
  (map count coll))

(element-lengths ["foo" "bar" "" "quux"])  ;=> (3 3 0 4)
(element-lengths ["x" [:a :b :c] {:y 42}]) ;=> (1 3 1)

;; 맵 : 맵,함수,콜렉션 = 함수 다 적용한 콜렉션으로 출력.
;; (count {:a 1}) 1 이라니...

(defn second-elements [coll]
  (let [sec* (fn [x](second x))]
  (map sec* coll)))

(second-elements [[1 2] [2 3] [3 4]]) ;=> (2 3 4)
(second-elements [[1 2 3 4] [1] ["a" "s" "d" "f"]])
;=> (2 nil "s")


(def china {:name "China Miéville", :birth-year 1972})
(def octavia {:name "Octavia E. Butler"
              :birth-year 1947
              :death-year 2006})
(def friedman {:name "Daniel Friedman" :birth-year 1944})
(def felleisen {:name "Matthias Felleisen"})

(def cities {:title "The City and the City" :authors [china]})
(def wild-seed {:title "Wild Seed", :authors [octavia]})
(def embassytown {:title "Embassytown", :authors [china]})
(def little-schemer {:title "The Little Schemer"
                     :authors [friedman, felleisen]})

(def books [cities, wild-seed, embassytown, little-schemer])

(defn titles [coll]
  (if (contains? coll :title)
    (:title coll)
    (map :title coll)))

(titles [cities]) ;=> ("The City and the City" )
(titles books)
;=> ("The City and the City" "Wild Seed"
;    "Embassytown" "The Little Schemer")


(defn author-names [book]
;;   (map :name (:authors book)))
  (map :name (:authors book)))

(author-names cities)

(defn all-author-names [books]
  (set (apply concat (map author-names books))))

(all-author-names books)

(set '(1 2 3))
(set [1 2 3])


(repeat 5 "*") ;=> ("*" "*" "*" "*" "*")
(repeat 3 "~o~") ;=> ("~o~" "~o~" "~o~")

(defn stars [numb]
  (repeat numb "*"))

(stars 1) ;=> "*"
(stars 7) ;=> "*******"
(stars 3) ;=> "***"

(defn monotonic? [coll]
  (or (apply >= coll) (apply <= coll)))

(monotonic? [1 2 3])     ;=> true
(monotonic? [0 1 10 11]) ;=> true
(monotonic? [3 2 0 -3])  ;=> true
(monotonic? [3 2 2])     ;=> true    Not strictly monotonic
(monotonic? [1 2 1 0])   ;=> false


(defn toggle [coll ke]
  (if (contains? coll ke)
    (disj coll ke)
    (conj coll ke)))

(toggle #{:a :b :c} :d) ;=> #{:a :c :b :d}
(toggle #{:a :b :c} :a) ;=> #{:c :b}


(defn contains-duplicates? [coll]
  (if (= (count coll) (count (set coll)))
         false
         true))

(contains-duplicates? [1 1 2 3 -40]) ;=> true
(contains-duplicates? [1 2 3 -40]) ;=> false
(contains-duplicates? [1 2 3 "a" "a"]) ;=> true
