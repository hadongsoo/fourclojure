(ns fourclojure.core)


(nth [1 2 3 4 5 6] 2)

(((fn [f]
  (fn [& args]
    (apply f (reverse args))))
 nth) 2 [1 2 3 4 5])


(
  (
   ((fn [& f1]
      (fn [f2]
        (fn [f3]
          (list f1 f2 f3)))) 1)
  2)
 '(4 5 6))

((fn [data & data2]
  data)
1 2 3 4)

;; 함수 아규먼트가 한번 더 감싸지는 이유는, 첫번째 아규먼트 외엔 모두 한 콜렉션으로 처리되서 인듯

