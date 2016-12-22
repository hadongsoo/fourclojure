(ns fourclojure.core)

;; false

(boolean "string")
(boolean 0)
(boolean 1)
(boolean nil)
(boolean false)
(boolean [])
(boolean {})

(if -1
  true
  false)

(defn teen? [n]
    (and (> 20 n) (< 9 n)))

(teen? 8)
(teen? 11)
(teen? 22)

(defn not-teen? [n]
  ((complement teen?) n))

(not-teen? 8)
(not-teen? 11)
(not-teen? 22)


(defn abs [n]
  (when (number? n)
    (if (> 0 n)
      (* -1 n)
      n)))

(abs 0)


(defn leap-year? [numb]
  (when (number? numb)
    (and
      (= 0 (mod numb 4))
      (or (= 0 (mod numb 400))
          (not (= 0 (mod numb 100))))
      )))

(leap-year? 100)
(leap-year? 100) ;=> false
(leap-year? 200) ;=> false
(leap-year? 400) ;=> true
(leap-year? 12)  ;=> true
(leap-year? 20)  ;=> true
(leap-year? 15)  ;=> false

