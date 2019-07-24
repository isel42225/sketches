(ns first.just-enough-clj)

;; Global Variables
(def test-list '(1 2 3 4))

;; Exercise 1 function	second	that returns	the	second	element	of	a	list
(def second (fn [list] (nth list 1) ) )
(second test-list)

;; Exercise 2 	Give	two	implementations	of	third,	which	returns	the	third	element
;of	a	list.
(def third (fn [list] (nth list 2) ) )
(def third2 (fn [list] (second (rest list) ) ))

;; Exercise 3
(def square (fn [number] (* number number)))
(def sum-all (fn [list] (apply + list)))
(def add-squares (fn [& numbers] (sum-all (map square numbers))))

;; Exercise	4:	The	range	function	produces	a	sequence	of	numbers
; Using	it	and	apply,	implement	a	bizarre	version	of	factorial	that	uses	neither
; iteration	nor	recursion.
; (range 1 5) => (1 2 3 4)
; apply * (1 2 3 4) => 1*2*3*4
(def factorial (fn [nr] (apply * (range 1 (inc nr)))))

; Exercise 5: