(ns fourclojure.core)

;;26 fibonacci sequence

(#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 3)

(#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 4)

((defn fibo* [[a b]]
  [b (+ a b)]
   )[1 1])

(fibo* [1 3])

;;(#(take 5 (map first (iterate fibo* [1 1]))))


;;27 Palindrome Detector
;;seq make any Collection > seq

;; (reverse seq '(1 2 3 4 5))

 (reverse (seq '(1 2 3)))

(seq '(1 2 3 4 5))

(seq [1 2 3 [3 4] 4])

(seq "hahahahah")

(defn palindrome [x]
  ;;(list (= x (reverse x)))
  (= (seq x) (reverse (seq x)))
  )

(palindrome '(1 2 1))
(palindrome "racecar")
(palindrome "rre")

;; shorter
(#(= (seq %) (reverse (seq %))) '(1 2 1))
(#(= (seq %) (reverse (seq %))) "helleh")

;;28 flatten > pass

;;29 get the caps
(require 'clojure.string)
(#(clojure.string/capitalize %) "HeLlO, WoRlD!")

(#(re-seq #"[A-Z]" %) "HeLlO, WoRlD!")

(#(apply str (re-seq #"[A-Z]" %)) "HeLlO, WoRlD!")

(#(apply str (re-seq #"[A-Z]" %)) "HeLlO, WoRlD!")

(#(filter %)  "HeLlO, WoRlD!")

(defn separate-dot [arg]
  (re-seq #"\d" arg))

(defn separate-space [arg]
  (re-seq #"\w+" arg))

(separate-dot "asdf asdf 1.1.5")
(separate-space "asdf asdf 1.1.5")

;; apply : collect items / map : doing each others
;; re-seq

;; (#(apply str (re-seq #"[A-Z]" %) "HeLlO, WoRlD!")



;; 41 Drop Every Nth Item

(def list1 [1 2 3 4 5 6 7 8 9 10 11])
(partition-all 4 list1)

(defn droppernth [arg nth]
  (into [] (flatten (list (first (partition-all nth arg))
  (map rest (rest (partition-all nth arg)))))))

;;   (first (partition-all nth arg)) (map rest (partition-all nth arg)))

(droppernth list1 3)

(concat)

(#(into []
        (flatten (map rest (partition-all %2 (concat [0] %)))))
  [:a :b :c :d :e :f] 2)
;   [1 2 3 4 5 6 7 8] 3)
; [1 2   4 5   7 8]


(#(partition-all (dec %2) %2 %) [1 2 3 4 5 6 7 8] 3)

; partition-all 의 스펙을 잘 모르는채로,
; 임의로 숫자 하나를 더 삽입해서 앞자리를 모두 없애는 방식으로 진행
; 스펙 자세히 보기가 중요한듯

; nth* making

(defn nth* [nthseq nthnum]
;;   (first (first
           (rest (partition (dec nthnum) nthseq))
;;            ))
  )

(nth* "hello" 2)
(nth* '(1 2 3 4 5) 2)


