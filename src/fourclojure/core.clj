(ns fourclojure.core)

;#50 split by type
(type [1 2 3 4])

(#(= (type %1) (type %2)) :b :a)

;; (partition-by (fn [& arg](arg))
;;     [:a "foo"  "bar" :b]

;; (fn (partial list) [:a "foo"  "bar" :b])

; comp 와 partial 의 개념 알게 됌.

(vals {:a 1 :b 2})
; vals 함수 알게 됌. 맵에서 값만 아웃풋

((comp list (partial group-by type)) [:a "foo"  "bar" :b])

((fn [arg]
  (group-by type arg))
[:a "foo"  "bar" :b])

; 타입별로 그룹화 해서 출력, 하면 항목 값으로 나뉘어진 맵 출력, comp vals로 값만 다시 뿌린다.

; group-by 는 f coll 인자로 f 함수에 맞는 항목만 coll에서 나눠준다
