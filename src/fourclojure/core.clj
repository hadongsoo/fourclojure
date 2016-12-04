(ns fourclojure.core)

;#49 split a sequence

(#(list (into [] (take %1 %2))(into [] (drop %1 %2))) 3 [1 2 3 4 5 6])
; take 와 drop 개념을 떠올림 1차 시도

(defn split-at* [pred coll]
  [(take pred coll)(drop pred coll)] )

(split-at* 3 [1 2 3 4 5])

; defn 함수 형태로 먼저 만들어봄

(fn [pred coll]
  [(take pred coll)(drop pred coll)])

; short version


