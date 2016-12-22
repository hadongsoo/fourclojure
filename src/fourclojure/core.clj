(ns fourclojure.core)

(def book {:title "The City and the City"
           :authors [{:name "China Miéville", :birth-year 1972}]
           :test {:test-nest "keykeykye"}})

(val (first (first (get book :authors)))) ;=> "The City and the City"

(get-in book [:test :test-nest])


(:title book)

(:name book)


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

(defn title-length [coll]
  (count (:title coll)))

(title-length cities)         ;=> 21
(title-length wild-seed)      ;=> 9
(title-length little-schemer) ;=> 18


(defn author-count [coll]
  (count (:authors coll)))

(author-count cities)         ;=> 1
(author-count wild-seed)      ;=> 1
(author-count little-schemer) ;=> 2

(defn multiple-authors? [coll]
  (if (second (:authors coll))
              true
              false))

(multiple-authors? cities)         ;=> false
(multiple-authors? wild-seed)      ;=> false
(multiple-authors? little-schemer) ;=> true
