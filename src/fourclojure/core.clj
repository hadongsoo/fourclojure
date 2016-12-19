(ns fourclojure.core)

;; #28 Flatten a Sequence

;; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
;; (= (__ '((((:a))))) '(:a))

(def no-int? (complement number?))
(def no-sequential? (complement sequential?))

(no-int? "1")
(no-int? 1)
(number? 1)
(number? "1")

(complement sequential? ["a" "b"])

(tree-seq seq? identity '((1 2 (3)) (4)))

(tree-seq sequential? seq [1 2 [3 [4]] [5]])

(filter (complement sequential?) (rest (tree-seq sequential? seq [1 2 [3 [4]] [5]])))

(tree-seq sequential? seq [1 2 [3 [4]] [5]])
(tree-seq sequential? identity [1 2 [3 [4]] [5]])
(rest (tree-seq sequential? seq [1 2 [3 [4]] [5]]))

(tree-seq sequential? seq [1 ["a" 2] "b" 3 4 5])

[1 2 [3 [4]][5]]

 1 2 [3 [4]]
      3 [4]
         4  [5]
             5

[1 2 [3 [4]][5]]
 1 2 [3 [4]]
      3 [4]
         4  [5]
             5
[1 ["a" 2] "b" 3 4 5]
 1 ["a" 2]
    "a" 2
           "b" 3 4 5

;; tree-seq 에 대한 고민. 트리 구조되는 기능 자체를 알게 되면 그 이후에 flatten은 이해할듯

(seq? [1])
(sequential? [1])

;; seq?는 type test이며 ISeq인 애만 체크
;; sequential? 는 capabiliites 이며 sequential한 애만 체크

(seq? '(1 2 3));; true
(seq? [1 2 3])   ; for sequential?, returns true;; false
(seq? (range 1 5));; true
(seq? 1);; false
(seq? {:a 2 :b 1});; false

(type [1 2 3])
(type {:a 2 :b 1})
(type [:a])
(type [:a 0])

(instance? clojure.lang.PersistentVector [1 2 3])

;; (instance? clojure.lang.PersistentArrayMap {:a})

;; sequential에 대한 고민. seq?와 sequential? 의 차이.


(#(filter (complement sequential?) (rest (tree-seq sequential? seq %))) '((1 2) 3 [4 [5 6]]))
   (#(filter (complement sequential?) (rest (tree-seq sequential? seq %)))'((1 2) 3 [4 [5 6]]))


;; 이번에도 해결못한 flatten tree-seq 이해가 어려워 대강만 이해했음
