(ns p-p-p-pokerface)

(def high-seven                   ["2H" "3S" "4C" "5C" "7D"])
(def pair-hand                    ["2H" "2S" "4C" "5C" "7D"])
(def two-pairs-hand               ["2H" "2S" "4C" "4D" "7D"])
(def three-of-a-kind-hand         ["2H" "2S" "2C" "4D" "7D"])
(def four-of-a-kind-hand          ["2H" "2S" "2C" "2D" "7D"])
(def straight-hand                ["2H" "3S" "6C" "5D" "4D"])
(def low-ace-straight-hand        ["2H" "3S" "4C" "5D" "AD"])
(def high-ace-straight-hand       ["TH" "AS" "QC" "KD" "JD"])
(def flush-hand                   ["2H" "4H" "5H" "9H" "7H"])
(def full-house-hand              ["2H" "5D" "2D" "2C" "5S"])
(def straight-flush-hand          ["2H" "3H" "6H" "5H" "4H"])
(def low-ace-straight-flush-hand  ["2D" "3D" "4D" "5D" "AD"])
(def high-ace-straight-flush-hand ["TS" "AS" "QS" "KS" "JS"])

(def rank->integer {\T 10,
                    \J 11,
                    \Q 12,
                    \K 13,
                    \A 14})

(defn rank [card]
  (let [[r _] card]
    (if (Character/isDigit r)
      (Integer/valueOf (str r))
      (rank->integer r))))

(defn suit [card]
  (let [[_ s] card]
    (str s)))


(defn pair? [hand]
  (let [ranks (map rank hand)
        freqs (vals (frequencies ranks))]
    (= (apply max freqs) 2)))

(defn three-of-a-kind? [hand]
  (let [ranks (map rank hand)
        freqs (vals (frequencies ranks))]
    (= (apply max freqs) 3)))


(defn four-of-a-kind? [hand]
  (let [ranks (map rank hand)
        freqs (vals (frequencies ranks))]
    (= (apply max freqs) 4)))

(defn flush? [hand]
  (let [suits (map suit hand)
        freqs (vals (frequencies suits))]
    (= (apply max freqs) 5)))

(defn full-house? [hand]
  (let [ranks (map rank hand)
        freqs (vals (frequencies ranks))]
    (= (set freqs) #{2,3})))

(defn two-pairs? [hand]
  (let [ranks (map rank hand)
        freqs (sort (vals (frequencies ranks)))]
    (or
      (= freqs [1,2,2])
      (= freqs [1,4]))))

(defn straight? [hand]
  (let [ranks-ace-high (map rank hand)
        ranks-ace-low (replace {14 1} ranks-ace-high)
        low-1 (apply min ranks-ace-high)
        low-2 (apply min ranks-ace-low)]
    (or
      (= (sort ranks-ace-high) (range low-1 (+ low-1 5)))
      (= (sort ranks-ace-low) (range low-2 (+ low-2 5))))))



(defn straight-flush? [hand]
  (and
    (straight? hand)
    (flush? hand)))



(defn high-card? [hand]
  true)

(def liste-parser #{ [pair?  1]
                     [two-pairs? 2]
                     [three-of-a-kind? 3]
                     [straight? 4]
                     [flush?  5]
                     [full-house?  6]
                     [four-of-a-kind?  7]
                     [straight-flush?  8]})

(defn value [ hand ]
;;   (apply max
         (map (fn [pair]
                    (if ((first pair) hand)
;;                       (second pair)
                      (type (first pair))
                      0))
                  liste-parser))
;;   )


(def testli #{[pair? 1] [two-pairs? 2] [straight? 3]})

(map (fn [coll]
       ()) testli)

(defn val2 [hand]
  (map (fn [pair]
         (if ((first pair) hand)
           (second pair)
           0
           )
           ) testli))

(defn val3 [coll]
  (let [m [max min count]]
    ((nth m 2) coll)))

(val3 [3 2 1 4 5])



(val2 high-seven)
(val2 two-pairs-hand)
(val2 straight-hand)


(value high-seven)           ;=> 0
(value pair-hand)            ;=> 1
(value two-pairs-hand)       ;=> 2
(value three-of-a-kind-hand) ;=> 3
(value straight-hand)        ;=> 4
(value flush-hand)           ;=> 5
(value full-house-hand)      ;=> 6
(value four-of-a-kind-hand)  ;=> 7
(value straight-flush-hand)  ;=> 8

;; 처음 찾은 방법
;; https://github.com/iloveponies/p-p-p-pokerface/pull/891/commits/93c9cf892ecbdac8a4e65466acc7d34d3ad19153#diff-cb33a7278bd60af12841774e5bb4fe9aL33

;; 단순한 방법
;; https://github.com/iloveponies/p-p-p-pokerface/pull/865/commits/3829c89d9536fdd6ca98c7dfd313892eed861a6b#diff-cb33a7278bd60af12841774e5bb4fe9aL33

;; 내가 바라는 방법
;; https://github.com/iloveponies/p-p-p-pokerface/pull/846/commits/0a970b287f82b1862067455fc8ed8e227147d3c6#diff-cb33a7278bd60af12841774e5bb4fe9aR166

