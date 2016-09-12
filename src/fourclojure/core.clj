(ns fourclojure.core)

;;26 fibonacci sequence

(#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 3)

(#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 4)

((defn fibo* [[a b]]
  [b (+ a b)]
   )[1 1])

(fibo* [1 3])

(#(take 5 (map first (iterate fibo* [1 1]))))
