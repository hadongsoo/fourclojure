(ns fourclojure.core)

;; (defn add-author [coll x]
;;   (let [[x] coll]
;;   (list coll x)))


(def little-schemer {:title "The Little Schemer"
    :authors [{:birth-year 1944, :name "Daniel Friedman"}
              {:name "Matthias Felleisen"}]})

;; (add-author little-schemer {:name "Gerald J. Sussman"})
;=> {:title "The Little Schemer"
;    :authors [{:birth-year 1944, :name "Daniel Friedman"}
;              {:name "Matthias Felleisen"}
;              {:name "Gerald J. Sussman"}]}
;; (add-author {:authors [{:name "Juhana"}]} {:name "Jani"})
;=> {:authors [{:name "Juhana"} {:name "Jani"}]}

(def testcoll {:a 123 :b [{:c 456 :d 789}]})

(defn add-author [coll kwrd]
    (assoc coll :authors (conj (:authors coll) kwrd)))

(add-author little-schemer {:name "Gerald J. Sussman"})
(add-author {:authors [{:name "Juhana"}]} {:name "Jani"})
(assoc little-schemer :authors  (conj []{:name "dongsoo"}))


;; conj로 기존 데이터 + 새값 합치고, 그걸 assoc로 위치 지정해준다.
;; 기존 데이터를 다시 넣는 방법에 대해서 고민했음
