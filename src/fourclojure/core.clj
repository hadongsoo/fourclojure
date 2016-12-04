(ns fourclojure.core)

;#48 some
(some #{2 3} '(1 2 3 4 5))
(some #(when (even? %) %) [5 6 7 8])

;some 말 그대로. 하나라도 있으면, 이라는 의미인듯.
;해쉬 맵의 마지막 수치를 다음 리스트에서 찾아서 일치하면 바로 아웃풋



