(ns fourclojure.core)

;; 100
;; Least Common Multiple

;; (== (__ 2 3) 6)
;; (== (__ 7 5/7 2 3/5) 210)




(defn numb-nt [i] (take i (rest (range))))

(map #(* 2 %) (numb-nt 10))

;; (take 10 (mapv #(list %) (rest (range))))

(defn numb-nt2 [i] (map #(* i %) (rest (range))))

(take 10 (numb-nt2 3))
(take 10 (numb-nt2 2))

;; 배수 목록 뽑기


;;(map + [1 2 3 4 5] (rest (range)))

;; map으로 둘을 비교할 필요없다
;; 첫번째 중복된 수만 찾으면 된다.

(defn gcd [a b]
        (if (zero? b)
          a
          (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

;; gcd를 이용한 방법
;; https://rosettacode.org/wiki/Least_common_multiple#Clojure


(lcm 12 74)

(gcd 100 24)
(mod 100 24) ;; mod

(mod 10 2)
(mod 10 3) ;; mod is 나머지?
(mod -2 5) ;; -2을 5로 나눌 수 없으므로, -로 바꿔 남는 값을 보여준다
(mod -3 6)
(rem -3 6) ;; rem은 절대값이 아님
(mod -10 3)
(rem -10 3)

;; I just review about GCD and MOD and REM



;; (map #(same? % 3) [1 2 3])


(defn same? [a b]
  (when (= a b) a))

;; (map [1] [1 2 3])

;; (defn first-of-2list [a b](first (clojure.set/intersection a b)))

;; (first-of-2list #{2 4 6 8 10} #{6 7 8 9})
;; ;;(take 10 (into #{} (numb-nt2 3)))

;; (clojure.set/intersection [1 2 3 4 5] [3])

(defn lcm2 [a b & c]
  (let [gcd (fn [a b]
              (if (zero? b)
                a
                (recur b (mod a b))))
        lcm (fn [a b]
              (/ (* a b) (gcd a b)))]
    (reduce lcm [a b])
    ))

(defn lcm3
  ([a b]
   (let [gcd (fn [a b]
              (if (zero? b)
                a
                (recur b (mod a b))))
        lcm (fn [a b]
              (/ (* a b) (gcd a b)))]
     (lcm a b)))
  ([a b & c]
   (reduce lcm (apply vector a b c))))

;; (a b '(c)) > [a b c]

((fn [a b & c]
  (apply vector a b c)) 2 3 4)




((fn [a b & c]
  (cons (list a b) c)) 2 3 4)

(cons 1 [2 3])
(conj [1] 2)
(conj '(1) 2)


(lcm2 2 3)

(lcm2 7 5/7 2 3/5)

(lcm3 2 3)
(lcm3 2 3 4)
(lcm3 7 5/7 2 3/5)


((fn
  ([& arg]
   (let [gcd (fn [a b]
              (if (zero? b)
                a
                (recur b (mod a b))))]
     (/ (reduce * arg) (reduce gcd arg)))))
;;      (reduce gcd arg))))
 12 18 4)

;; 결국 풀지 못해서, 참고한 정답 예시
;; 최대공약수의 계산식을 ruduce랑 같이 쓸 생각은 어떻게 하는거지..
