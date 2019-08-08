; Exercise 1
; Write	a	function	multiples	that	takes	a	number	and	returns	a	sequence	of	all	its
; non-prime	multiples	less	than	100.
(def multiples
  (fn [n]
    (range (* n 2) 101 n)))

; Exercise 2
; Use	the	Sequence	monad	or	for	(your	choice!)	to	find	all	non-primes	less	than
; 100.	Duplicates	are	OK.
; Hint:	You’ll	need	two	steps	and	a	body	that	just	returns	a	value.
(def nonprimes
  (for [a (range 2 11)
        b (multiples a)]
    b))


; Exercise	3
; Use	sets	to	calculate	all	the	primes	less	than	100.
(def nonprime? )
(def primes
  (remove (fn [n]
            (not (nil? ((set nonprimes) n))))
          (range 2 101)))