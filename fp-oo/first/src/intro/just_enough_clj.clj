(ns intro.just-enough-clj)

;; Global Variables
(def num-list '(1 2 3 4))
(def letters-list '(A B A D B E R))

;; Exercise 1 function	second	that returns	the	second	element	of	a	list
(def second
  (fn [list]
    (nth list 1) ) )
(second num-list)

;; Exercise 2 	Give	two	implementations	of	third,	which	returns	the	third	element
;of	a	list.
(def third
  (fn [list]
    (nth list 2) ) )
(def third2
  (fn [list]
    (second (rest list) )))

;; Exercise 3
(def square
  (fn [number]
    (* number number)))
(def sum-all
  (fn [list]
    (apply + list)))
(def add-squares
  (fn [& numbers]
    (sum-all (map square numbers))))

;; Exercise	4:	The	range	function	produces	a	sequence	of	numbers
; Using	it	and	apply,	implement	a	bizarre	version	of	factorial	that	uses	neither
; iteration	nor	recursion.
; (range 1 5) => (1 2 3 4)
; apply * (1 2 3 4) => 1*2*3*4
(def factorial
  (fn [nr]
    (apply * (range 1 (inc nr)))))

; Exercise 5:
;; REPEAT
;; Given a list L. Suppose its third and fifth elements are
;; A and B. Produce this list:
;;    ( (A B) (A B) (A B) (A B) )
(def repeat-sol
  (fn [letters]
    (repeat 3 (concat [(nth letters 2) (nth letters 4)]))))

; DROP and DROP-LAST
;; Return the middlemost 2 elements of an even-element sequence.
;; [1 2 3 4] => (2 3)
;; [1 2 3 4 5 6] => (3 4)
;; [1 2 3 4 5 6 7 8] => (4 5)
;; out-numbers = length - 2
(def out-numbers
  (fn [seq]
    (/ ( - (count seq) 2) 2)))
(def middlemost
  (fn [seq]
    (drop (out-numbers seq) (drop-last (out-numbers seq) seq))))

;; PARTITION
;; Convert (1 2 3 4) into (3 4 1 2)
(def convert (fn [seq] (flatten (reverse (partition 2 seq)))))

;; Exercise	6:	Implement	this	function:
;; (prefix-of?	candidate	sequence):	Both	arguments	are	sequences.	Returns
;; true	if	the	elements	in	the	candidate	are	the	intro	elements	in	the	sequence:
;; 1	user>	(prefix-of?	[1	2]	[1	2	3	4])
;; 2	true
;; 3	user>	(prefix-of?	'(2	3)	[1	2	3	4])
;; 4	false
(def prefix-of?
  (fn [candidate seq]
    (= candidate (drop-last (count candidate) seq))))

;; Exercise	7:	Implement	this	function:
;; (tails	sequence):	Returns	a	sequence	of	successively	smaller	subsequences	of
;; the	argument.
;; 1	user>	(tails	'(1	2	3	4))
;; 2	((1	2	3	4)	(2 3 4)	(3 4)	(4)	())
;; To	implement	tails,	use	range,	which	produces	a	sequence	of	integers.	For
;; example,	(range	4)	is	(0 1 2 3).
(def tails
  (fn [seq]
    (map drop
         (range (inc (count seq)))
         (repeat (inc (count seq)) seq))))