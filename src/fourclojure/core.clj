(ns fourclojure.core)

;; #38 Maximum value

;; (= (__ 1 8 3 4) 8)
;; (= (__ 1 8 3 4) 8)
;; (= (__ 30 20) 30)
;; (= (__ 45 67 11) 67)
;; (= (__ 45 67 11) 67)

(#(last (sort %&)) 45 67 11)


;; #29 Get the Caps

;; (= (__ "HeLlO, WoRlD!") "HLOWRD")
;; (empty? (__ "nothing"))
;; (= (__ "$#A(*&987Zf") "AZ")


(apply str (re-seq #"[A-Z]" "HeLlO, WoRlD!"))

;; 정규표현식을 간단하게만 써서 대문자만 추출하는 방법
;; 언제나 정규표현식은 헷갈린다. 유용한 간단한건 알아두면 좋을듯.

(defn capital? [stragr]
  (if (string? stragr)
    (if (re-seq #"[A-Z]" (str (first stragr))) true false)
    false))

(capital? "ABc")
(capital? "3")
(capital? 4)

(filter capital? [1 2 3 4 ])

(filter capital? ["3" "A" "a" "C"])

;; 공부 재개하고 첨 만들어본 함수. 내부에 (str (first xxxx)) 형식은 개선해야할듯 하다.

