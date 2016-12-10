(ns fourclojure.core)

;# 134 nil 키값 검사하기 //초급중급순으로 난이도 변경

;; (true?  (__ :a {:a nil :b 2}))
;; (false? (__ :b {:a nil :b 2}))
;; (false? (__ :c {:a nil :b 2}))


((fn [valdata coll]
   (if (contains? coll valdata)
     (= nil (val (find coll valdata)))
     false))
;;    (= nil (val coll)))
:a {:a nil :b 2})
;; :a {:a nil :b 2})

(contains? {:a nil :b 2} :c)


;; contains? 과 find에 대해 알게 됐다. val 또한..


;;   ((fn [valdata coll]
;;      (if (contains? coll valdata)
;;        (= (coll valdata) nil)
;;        false))
;;   :c {:a nil :b 2})

;; 맵 뒤에 키가 있으면 값을 뱉어내준다. find val 등 함수를 사용하지 않아도 된다.
